package cur.pro.entity;

public class TagMapper {
    private Integer game;

    private Integer tag;

    public TagMapper(Integer game, Integer tag) {
        this.game = game;
        this.tag = tag;
    }

    public TagMapper() {
        super();
    }

    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }
}