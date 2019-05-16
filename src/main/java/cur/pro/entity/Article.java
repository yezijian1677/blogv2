package cur.pro.entity;

import java.util.Date;

public class Article {
    private Integer id;

    private String title;

    private String keywords;

    private String describe;

    private Integer click;

    private Date ctime;

    private Date utime;

    private Integer catagoryId;

    private String content;

    public Article(Integer id, String title, String keywords, String describe, Integer click, Date ctime, Date utime, Integer catagoryId, String content) {
        this.id = id;
        this.title = title;
        this.keywords = keywords;
        this.describe = describe;
        this.click = click;
        this.ctime = ctime;
        this.utime = utime;
        this.catagoryId = catagoryId;
        this.content = content;
    }

    public Article() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Integer getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Integer catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}