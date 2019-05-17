package cur.pro.services.impl;

import cur.pro.entity.*;
import cur.pro.entity.dto.ArticleDTO;
import cur.pro.mapper.*;
import cur.pro.mapper.KindMapper;
import cur.pro.mapper.TagMapper;
import cur.pro.services.UserService;
import cur.pro.utils.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private KindMapper kindMapper;
    @Autowired
    private KindMapperMapper kindMapperMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private TagMapperMapper tagMapperMapper;
    @Autowired
    private ImgMapper imgMapper;
    @Autowired
    private RedisPoolUtil redisPoolUtil;
    @Autowired
    private JsonUtil jsonUtil;


    public Result login(String username, String password) {
        if (username == null || password == null) {
            return Result.fail(MsgCenter.EMPTY_LOGIN);
        }
        User user = userMapper.selectByName(username);
        if (user == null || !user.getPassword().equals(password)){
            return Result.fail(MsgCenter.ERROR_LOGIN);
        }

        String token = UUID.randomUUID().toString().replaceAll("-", "");
        //登录状态保留二十四小时
        redisPoolUtil.setEx(token, String.valueOf(user.getUserId()), 60*60*24);
        return Result.success(token);
    }

    public Result getArticles() {
        List<Article> articleList = articleMapper.selectAll();
        List<ArticleDTO> articleDTOList = new ArrayList<ArticleDTO>();
        for (Article article : articleList) {
            List<Kind> kinds = null;
            //根据文章id获取所有分类id
            List<Integer> kindIds = kindMapperMapper.selectKindByArticleId(article.getId());
            if (kindIds.size() != 0) {
                //根据分类id获取相应的分类
                kinds = kindMapper.selectByIds(kindIds);
            }
            ArticleDTO articleDTO = new ArticleDTO(article, kinds, null, null);
            articleDTOList.add(articleDTO);
        }

        return Result.success(articleDTOList);
    }

    @Transactional
    public Result addArticles(Article article, Integer[] kind, MultipartFile header, MultipartFile[] pics, String path) throws IOException {
        if (StringUtils.isBlank(article.getTitle()) || StringUtils.isBlank(article.getContent())
        || StringUtils.isBlank(article.getDescribe()) ){
            return Result.fail(MsgCenter.ERROR_PARAMS);
        }

        if (!header.getContentType().equalsIgnoreCase("image/jpeg") && !header.getContentType().equalsIgnoreCase("image/png")) {
            return Result.fail(MsgCenter.ERROR_FILE_TYPE);
        }
        for (MultipartFile pic : pics) {
            if (!pic.getContentType().equalsIgnoreCase("image/jpeg") && !pic.getContentType().equalsIgnoreCase("image/png")) {
                return Result.fail(MsgCenter.ERROR_FILE_TYPE);
            }
        }

        articleMapper.insert(article);
        if (kind != null && kind.length > 0) {
            kindMapperMapper.insertKindBatch(article.getId(), Arrays.asList(kind));
        }
        Img image = new Img();
        image.setArticleId(article.getId());
        String headerType = null;
        if (header.getContentType().equalsIgnoreCase("image/jpeg")) {
            headerType = "jpg";
        } else if (header.getContentType().equalsIgnoreCase("image/png")) {
            headerType = "png";
        }
        image.setImg("/" + article.getId() + "/header." + headerType);
        imgMapper.insert(image);
        FileUtils.copyInputStreamToFile(header.getInputStream(), new File(path + "/" + article.getId(), "header." + headerType));
        int index = 1;
        List<String> imgs = new ArrayList<String>();
        for (MultipartFile pic : pics) {
            String type = null;
            if (pic.getContentType().equalsIgnoreCase("image/jpeg")) {
                type = "jpg";
            } else if (pic.getContentType().equalsIgnoreCase("image/png")) {
                type = "png";
            }
            //拼接写入数据库
            String img = "/" + article.getId() + "/" + index + "." + type;
            imgs.add(img);
            FileUtils.copyInputStreamToFile(pic.getInputStream(), new File(path + "/" + article.getId(), index + "." + type));
            index++;
        }
        imgMapper.insertBatch(article.getId(), imgs);
        return Result.success();
    }

    public Result updateArticleInfo(Article article) {
        if (article.getId() == null) {
            return Result.fail(MsgCenter.ERROR_PARAMS);
        }
        articleMapper.updateByPrimaryKeySelective(article);
        return Result.success();
    }

    public Result deleteArticle(Integer articleId) {
        if (articleId == null) {
            return Result.fail(MsgCenter.ERROR_PARAMS);
        }
        articleMapper.deleteByPrimaryKey(articleId);
        return Result.success();
    }
    //TODO
    public Result getArticles(int page) {
        PageUtil pageUtil = new PageUtil(articleMapper.selectNums(), page);
        List<Article> articles = articleMapper.selectByPage(pageUtil.getStartPos(), pageUtil.getSize());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("article", paresArticleDTO(articles));
        map.put("page", pageUtil);
        return Result.success(map);
    }

    public Result getArticleKind(Integer ArticleId) {
        if (articleMapper.selectById(ArticleId) == null) {
            return Result.fail(MsgCenter.ERROR_PARAMS);
        }
        //获取文章拥有的id
        List<Integer> kindIds = kindMapperMapper.selectKindByArticleId(ArticleId);
        //获取id所代表的kind
        List<Kind> kinds = kindMapper.selectByIds(kindIds);
        return Result.success(kinds);
    }

    @Transactional
    public Result updateArticleKind(Integer ArticleId, List<Integer> kinds) {
        kindMapperMapper.deleteByArticleId(ArticleId);
        kindMapperMapper.insertKindBatch(ArticleId, kinds);
        return Result.success();
    }

    @Transactional
    public Result addKind(String name) {
        Kind kind = kindMapper.selectByName(name);
        if (kind != null) {
            return Result.fail(MsgCenter.NAME_EXISTS);
        }
        kind = new Kind();
        kind.setName(name);
        if (1 == kindMapper.insert(kind)) {
            return Result.success();
        }

        return Result.fail(MsgCenter.ERROR);
    }

    @Transactional
    public Result managerKind(Integer kind, List<Integer> articles) {
        kindMapperMapper.deleteByKind(kind);
        kindMapperMapper.insertArticleBatch(kind, articles);
        return Result.success();
    }

    private List<ArticleDTO> paresArticleDTO(List<Article> articles){
        List<ArticleDTO> articleDTOList = new ArrayList<ArticleDTO>();
        for (Article article : articles){
            List<Tag> tags = null;
            List<Kind> kinds = null;
            List<Integer> tagIds = tagMapperMapper.selectTagByArticleId(article.getId());
            if (tagIds.size() != 0) {
                tags = tagMapper.selectByIds(tagIds);
            }
            List<String> img = imgMapper.selectByArticleId(article.getId());
            List<Integer> kindIds = kindMapperMapper.selectKindByArticleId(article.getId());
            if (kindIds.size()!=0){
                kinds = kindMapper.selectByIds(kindIds);
            }
            ArticleDTO articleDTO = new ArticleDTO(article, kinds, tags, img);
            articleDTOList.add(articleDTO);
        }
        return articleDTOList;
    }
}
