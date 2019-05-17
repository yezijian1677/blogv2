package cur.pro.entity.dto;

import cur.pro.entity.Article;
import cur.pro.entity.Kind;
import cur.pro.entity.Tag;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class ArticleDTO {

    private Integer id;

    private String title;

    private String keywords;

    private String describe;

    private Integer click;

    private Date ctime;

    private Date utime;

    private Integer catagoryId;

    private String content;

    private List<Kind> kinds;

    private List<Tag> tags;

    private List<String> img;

    public ArticleDTO(){

    }

    public ArticleDTO(Article article, List<Tag> tags, List<String> img) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.keywords = article.getKeywords();
        this.describe = article.getDescribe();
        this.click = article.getClick();
        this.ctime = article.getCtime();
        this.utime = article.getUtime();
        this.catagoryId = article.getCatagoryId();
        this.content = article.getContent();
        this.tags = tags;
        this.img = img;
    }

    public ArticleDTO(Article article,List<Kind> kinds, List<Tag> tags, List<String> img) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.keywords = article.getKeywords();
        this.describe = article.getDescribe();
        this.click = article.getClick();
        this.ctime = article.getCtime();
        this.utime = article.getUtime();
        this.catagoryId = article.getCatagoryId();
        this.content = article.getContent();
        this.kinds = kinds;
        this.tags = tags;
        this.img = img;
    }
}
