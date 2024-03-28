package com.example.Social.Web.post;

import com.example.Social.Web.content.Content;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @OneToOne
    @JoinColumn(name = "content_id")
    private Content content;
    private String post_content;
    private LocalDate date;

    public Post() {
    }

    public Post(Long post_id, Content content, String post_content, LocalDate date) {
        this.post_id = post_id;
        this.content = content;
        this.post_content = post_content;
        this.date = date;
    }

    public Post(Content content, String post_content, LocalDate date) {
        this.content = content;
        this.post_content = post_content;
        this.date = date;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
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
                "post_id=" + post_id +
                ", content=" + content +
                ", post_content='" + post_content + '\'' +
                ", date=" + date +
                '}';
    }
}
