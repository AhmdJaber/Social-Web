package com.example.Social.Web.content;

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
    private Long contentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @JsonIgnore
    @OneToMany
    private List<Reply> replies;

    private String type = null;
    public Content() {
    }

    public Content(Long contentId, User user, List<Reply> replies, String type) {
        this.contentId = contentId;
        this.user = user;
        this.replies = replies;
        this.type = type;
    }

    public Content(User user, List<Reply> replies, String type) {
        this.user = user;
        this.replies = replies;
        this.type = type;
    }

    public Content(User user, String type){
        this.user = user;
        this.type = type;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                "content Id=" + contentId +
                ", user=" + user +
                ", replies=" + replies +
                ", type='" + type + '\'' +
                '}';
    }
}
