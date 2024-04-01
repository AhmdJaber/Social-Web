package com.example.Social.Web.comment;

import com.example.Social.Web.content.Content;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Embeddable
public class CommentID implements Serializable {
    @OneToOne
    @JoinColumn(name = "content_id")
    private Content content;

    public CommentID() {
    }

    public CommentID(Content content) {
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
        return "CommentID{" +
                "content=" + content +
                '}';
    }
}
