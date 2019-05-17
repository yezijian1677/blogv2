package cur.pro.entity;

public class Img {
    private Integer articleId;

    private String img;

    public Img(Integer articleId, String img) {
        this.articleId = articleId;
        this.img = img;
    }

    public Img() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}