package model.bean;

public class Comment {
    private long id;
    private long userId;
    private long articleId;
    private String content;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", content='" + content + '\'' +
                '}';
    }

    public Comment () {}

    public Comment(long id, long userId, long articleId, String content) {
        this.id = id;
        this.userId = userId;
        this.articleId = articleId;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
