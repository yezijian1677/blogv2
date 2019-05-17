package cur.pro.services;

import cur.pro.entity.Article;
import cur.pro.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    /**
     * 管理员登录
     * 暂时不开放用户登录
     * 只做登录不注册
     */
    Result login(String username, String password);

    /**
     * 获取所有的文章
     * @return
     */
    Result getArticles();

    /**
     * 添加文章
     * @param article
     * @param kind
     * @param header
     * @param pics
     * @param path
     * @return
     */
    Result addArticles(Article article,
                       Integer[] kind,
                       MultipartFile header,
                       MultipartFile[] pics,
                       String path);

    /**
     * 更新文章信息
     * @param article
     * @return
     */
    Result updateArticleInfo(Article article);

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    Result deleteArticle(Integer articleId);

    /**
     * 获取文章分类
     * @param ArticleId
     * @return
     */
    Result getArticleKind(Integer ArticleId);

    /**
     * 更新文章分类
     * @param ArticleId
     * @param kinds
     * @return
     */
    Result updateArticleKind(Integer ArticleId, List<Integer> kinds);

    /**
     * 添加文章分类
     * @param name
     * @return
     */
    Result addKind(String name);

    /**
     * 管理分类对应的文章
     * @param kind
     * @param articles
     * @return
     */
    Result managerKind(Integer kind, List<Integer> articles);

}
