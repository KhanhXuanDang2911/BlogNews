package model.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import model.bean.User;

import java.util.Date;

public class Comment {

    int id;
    User author;

    int news_id;
    String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    Date created_at;

    public Comment(int id, User author, int news_id, String content, Date created_at) {
        this.id = id;
        this.author = author;
        this.news_id = news_id;
        this.content = content;
        this.created_at = created_at;
    }

    public Comment(){}

    public Comment(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
