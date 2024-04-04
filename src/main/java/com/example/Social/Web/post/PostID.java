package com.example.Social.Web.post;

import com.example.Social.Web.content.Content;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PostID implements Serializable {
    @OneToOne
    @JoinColumn(name = "post_id")
    private Content content;

    public PostID() {
    }

    public PostID(Content content) {
        this.content = content;
    }
}
