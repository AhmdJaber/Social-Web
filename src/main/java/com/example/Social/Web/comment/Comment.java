package com.example.Social.Web.comment;

import com.example.Social.Web.post.Post;
import com.example.Social.Web.reply.Reply;
import com.example.Social.Web.reply.ReplyService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Comment {
    @EmbeddedId
    @JoinColumn(name = "comment_id")
    private CommentID commentID;

    private String commentContent;
    private LocalDate date = LocalDate.now();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() {
    }

    public Comment(CommentID commentID, String commentContent, LocalDate date, Post post, List<Reply> replies) {
        this.commentID = commentID;
        this.commentContent = commentContent;
        this.date = date;
        this.post = post;
    }

    public Comment(String commentContent, LocalDate date, Post post, List<Reply> replies) {
        this.commentContent = commentContent;
        this.date = date;
        this.post = post;
    }

    public CommentID getCommentID() {
        return commentID;
    }

    public void setCommentID(CommentID commentID) {
        this.commentID = commentID;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", commentContent='" + commentContent + '\'' +
                ", date=" + date +
                ", post=" + post +
                '}';
    }
}