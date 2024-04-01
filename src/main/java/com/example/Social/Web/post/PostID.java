package com.example.Social.Web.post;

import com.example.Social.Web.content.Content;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Embeddable
public class PostID implements Serializable {
    @OneToOne
    @JoinColumn(name = "post_id")
    private Content content;

    public PostID() {
    }

    public PostID(Content content) {
        this.content = content;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostID{" +
                "content=" + content +
                '}';
    }
}
