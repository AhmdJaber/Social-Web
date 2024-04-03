package com.example.Social.Web.post;

import com.example.Social.Web.comment.Comment;
import com.example.Social.Web.reaction.Reaction;
import com.example.Social.Web.reply.Reply;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Post {
    @EmbeddedId
    @JoinColumn(name = "post_id")
    private PostID postID;

    private String post_content;
    private LocalDate date = LocalDate.now();

    @JsonManagedReference
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany
    @JoinColumn(name = "postReactions")
    private List<Reaction> reactions = new ArrayList<>();

    public Post() {
    }

    public Post(PostID postID, String post_content, LocalDate date, List<Comment> comments, List<Reaction> reactions) {
        this.postID = postID;
        this.post_content = post_content;
        this.date = date;
        this.comments = comments;
        this.reactions = reactions;
    }

    public Post(String post_content, LocalDate date, List<Comment> comments, List<Reaction> reactions) {
        this.post_content = post_content;
        this.date = date;
        this.comments = comments;
        this.reactions = reactions;
    }

    public PostID getPostID() {
        return postID;
    }

    public void setPostID(PostID postID) {
        this.postID = postID;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", post_content='" + post_content + '\'' +
                ", date=" + date +
                ", comments=" + comments +
                ", reactions=" + reactions +
                '}';
    }
}
