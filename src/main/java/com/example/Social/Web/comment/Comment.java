package com.example.Social.Web.comment;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.post.Post;
import com.example.Social.Web.reaction.Reaction;
import com.example.Social.Web.reply.Reply;
import com.example.Social.Web.reply.ReplyService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
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
    @JoinColumn(name = "commentReactions")
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
}