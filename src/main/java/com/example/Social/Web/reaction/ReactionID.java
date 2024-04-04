package com.example.Social.Web.reaction;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.user.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ReactionID implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;

    public ReactionID() {
    }

    public ReactionID(User user, Content content) {
        this.user = user;
        this.content = content;
    }
}
