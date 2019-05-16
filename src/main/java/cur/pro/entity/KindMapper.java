package cur.pro.entity;

public class KindMapper {
    private Integer article;

    private Integer kind;

    public KindMapper(Integer article, Integer kind) {
        this.article = article;
        this.kind = kind;
    }

    public KindMapper() {
        super();
    }

    public Integer getArticle() {
        return article;
    }

    public void setArticle(Integer article) {
        this.article = article;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }
}