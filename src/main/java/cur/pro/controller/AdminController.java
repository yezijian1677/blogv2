package cur.pro.controller;

import cur.pro.entity.Article;
import cur.pro.services.UserService;
import cur.pro.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Controller
@RequestMapping(value = "admin")
public class AdminController extends AbstractController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "login")
    public String login(){
        return "admin/login";
    }

    @PostMapping(value = "login")
    @ResponseBody
    public Result login(String username, String password, HttpServletResponse response) {
        Result result = userService.login(username, password);
        if (result.isSuccess()) {
            Cookie cookie = new Cookie("token", (String) result.getData());
            cookie.setPath("/");
            response.addCookie(cookie);
            return Result.success();
        }

        return result;
    }

    @GetMapping(value = "index")
    public String indexPage() {
        return "admin/article";
    }

    @PostMapping(value = "article")
    @ResponseBody
    public Result getArticles(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
        return userService.getArticles(page);
    }

    @PostMapping(value = "addArticle")
    @ResponseBody
    public Result addArticle(Article article, Integer[] kinds, MultipartFile header,
                             @RequestParam(value = "pics") MultipartFile[] pics)
        throws IOException{
        return userService.addArticles(article, kinds, header, pics,
                this.getSession().getServletContext().getRealPath("/WEB-INF/image").replaceAll("\\\\", "/"));
    }

    @PostMapping(value = "updateArticleInfo")
    @ResponseBody
    public Result updateArticleInfo(Article article) {
        return userService.updateArticleInfo(article);
    }

    @PostMapping(value = "getArticleKind")
    @ResponseBody
    public Result getArticleKind(Integer articleId){
        return userService.getArticleKind(articleId);
    }

    @PostMapping(value = "addKind")
    @ResponseBody
    public Result addKind(String kind){
        return userService.addKind(kind);
    }

    @PostMapping(value = "getAllArticles")
    @ResponseBody
    public Result getAllArticles(){
        return userService.getArticles();
    }

    @PostMapping(value = "manageKind")
    @ResponseBody
    public Result manageKind(Integer kind, Integer[] games) {
        return userService.managerKind(kind, Arrays.asList(games));
    }

    @PostMapping(value = "delArticle")
    @ResponseBody
    public Result delArticle(Integer articleId){
        return userService.deleteArticle(articleId);
    }


}
