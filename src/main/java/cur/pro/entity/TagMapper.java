package cur.pro.entity;

public class TagMapper {
    private Integer articleId;

    private Integer tag;

    public TagMapper(Integer articleId, Integer tag) {
        this.articleId = articleId;
        this.tag = tag;
    }

    public TagMapper() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }
}