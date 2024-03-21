package com.example.Social.Web.post;

import com.example.Social.Web.content.Content;
import com.sun.tools.attach.AgentInitializationException;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Post {
    @Id
    @OneToOne
    @JoinColumn(name = "post_id", referencedColumnName = "content_id")
    private Content content;
    private String post_content;
    private LocalDate date;

    public Post() {
    }

    public Post(Content content, String post_content, LocalDate date) {
        this.content = content;
        this.post_content = post_content;
        this.date = date;
    }

    public Post(String post_content, LocalDate date) {
        this.post_content = post_content;
        this.date = date;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content=" + content +
                ", post_content='" + post_content + '\'' +
                ", date=" + date +
                '}';
    }
}
