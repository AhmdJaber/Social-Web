package com.example.Social.Web.comment;

import com.example.Social.Web.content.Content;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Comment {
    @Id
    @OneToOne
    @JoinColumn(name = "comment_id")
    private Content content;

    private String comment_content;
    private LocalDate date;

    public Comment() {
    }

    public Comment(Content content, String comment_content, LocalDate date) {
        this.content = content;
        this.comment_content = comment_content;
        this.date = date;
    }

    public Comment(String comment_content, LocalDate date) {
        this.comment_content = comment_content;
        this.date = date;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content=" + content +
                ", comment_content='" + comment_content + '\'' +
                ", date=" + date +
                '}';
    }
}