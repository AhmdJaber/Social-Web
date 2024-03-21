package com.example.Social.Web.content;

import com.example.Social.Web.comment.Comment;
import com.example.Social.Web.post.Post;
import com.example.Social.Web.reaction.Reaction;
import com.example.Social.Web.reply.Reply;
import com.example.Social.Web.user.User;
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

    @OneToOne(mappedBy = "content")
    private Comment comment;

    @OneToOne(mappedBy = "content")
    private Post post;

    @OneToOne(mappedBy = "content")
    private Reply reply;

    @OneToMany(mappedBy = "content")
    private List<Reply> replies;

    public Content() {
    }

    public Content(Long content_id, User user_id, Comment comment, Post post, Reply reply, Reaction reaction) {
        this.content_id = content_id;
        this.user = user_id;
        this.comment = comment;
        this.post = post;
        this.reply = reply;
    }

    public Content(User user_id, Comment comment, Post post, Reply reply, Reaction reaction) {
        this.user = user_id;
        this.comment = comment;
        this.post = post;
        this.reply = reply;
    }

    public Long getContent_id() {
        return content_id;
    }

    public void setContent_id(Long content_id) {
        this.content_id = content_id;
    }

    public User getUser_id() {
        return user;
    }

    public void setUser_id(User user_id) {
        this.user = user_id;
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

    @Override
    public String toString() {
        return "Content{" +
                "content_id=" + content_id +
                ", user_id=" + user +
                ", comment=" + comment +
                ", post=" + post +
                ", reply=" + reply +
                '}';
    }
}
