package article.model;

public class Article {
    private int id;
    private String title;
    private String content;
    private int hit;
    private String regDate;
    private int userId;
    public Article(int id, String title, String content, String regDate, int userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.userId = userId;
        this.hit = 0;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
