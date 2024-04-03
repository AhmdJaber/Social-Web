package com.example.Social.Web.comment;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.post.Post;
import com.example.Social.Web.reaction.Reaction;
import com.example.Social.Web.reply.Reply;
import com.example.Social.Web.reply.ReplyService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @OneToMany
    @JoinColumn(name = "content_id")
    private List<Reply> replies;

    @OneToMany
    @JoinColumn(name = "reaction_id")
    private List<Reaction> reactions = new ArrayList<>();

    public Comment() {
    }

    public Comment(CommentID commentID, String commentContent, LocalDate date, Post post, List<Reply> replies, List<Reaction> reactions) {
        this.commentID = commentID;
        this.commentContent = commentContent;
        this.date = date;
        this.post = post;
        this.replies = replies;
        this.reactions = reactions;
    }

    public Comment(String commentContent, LocalDate date, Post post, List<Reply> replies, List<Reaction> reactions) {
        this.commentContent = commentContent;
        this.date = date;
        this.post = post;
        this.replies = replies;
        this.reactions = reactions;
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

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", commentContent='" + commentContent + '\'' +
                ", date=" + date +
                ", post=" + post +
                ", replies=" + replies +
                ", reactions=" + reactions +
                '}';
    }
}