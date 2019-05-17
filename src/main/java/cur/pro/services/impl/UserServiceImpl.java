package cur.pro.services.impl;

import cur.pro.entity.Article;
import cur.pro.mapper.UserMapper;
import cur.pro.services.UserService;
import cur.pro.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public Result login(String username, String password) {
        return null;
    }

    public Result getArticles() {
        return null;
    }

    public Result addArticles(Article article, Integer[] kind, MultipartFile header, MultipartFile[] pics, String path) {
        return null;
    }

    public Result updateArticleInfo(Article article) {
        return null;
    }

    public Result deleteArticle(Integer articleId) {
        return null;
    }

    public Result getArticleKind(Integer ArticleId) {
        return null;
    }

    public Result updateArticleKind(Integer ArticleId, List<Integer> kinds) {
        return null;
    }

    public Result addKind(String name) {
        return null;
    }

    public Result managerKind(Integer kind, List<Integer> articles) {
        return null;
    }
}
