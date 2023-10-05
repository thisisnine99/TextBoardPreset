package article.model;

public class Comment {
    private int id;
    private int articleId;
    private String content;
    private String regDate;
    public Comment(int id,int articleId, String content, String regDate) {
        this.id = id;
        this.articleId = articleId;
        this.content = content;
        this.regDate = regDate;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
