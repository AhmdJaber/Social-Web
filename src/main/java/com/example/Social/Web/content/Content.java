package com.example.Social.Web.content;

import com.example.Social.Web.comment.Comment;
import com.example.Social.Web.post.Post;
import com.example.Social.Web.reply.Reply;
import com.example.Social.Web.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long content_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToOne(mappedBy = "content")
    private Comment comment;

    @JsonIgnore
    @OneToOne(mappedBy = "content")
    private Post post;

    @JsonIgnore
    @OneToOne(mappedBy = "content")
    private Reply reply;

    @OneToMany(mappedBy = "content")
    private List<Reply> replies;

    private String type = null;
    public Content() {
    }

    public Content(Long content_id, User user, Comment comment, Post post, Reply reply, List<Reply> replies, String type) {
        this.content_id = content_id;
        this.user = user;
        this.comment = comment;
        this.post = post;
        this.reply = reply;
        this.replies = replies;
        this.type = type;
    }

    public Content(User user, Comment comment, Post post, Reply reply, List<Reply> replies, String type) {
        this.user = user;
        this.comment = comment;
        this.post = post;
        this.reply = reply;
        this.replies = replies;
        this.type = type;
    }

    public Long getContent_id() {
        return content_id;
    }

    public void setContent_id(Long content_id) {
        this.content_id = content_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Content{" +
                "content_id=" + content_id +
                ", user=" + user +
                ", comment=" + comment +
                ", post=" + post +
                ", reply=" + reply +
                ", replies=" + replies +
                ", type='" + type + '\'' +
                '}';
    }
}
