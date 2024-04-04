package com.example.Social.Web.reply;

import com.example.Social.Web.content.Content;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ReplyID implements Serializable {
    @OneToOne
    @JoinColumn(name = "reply_id")
    private Content content;

    public ReplyID() {
    }

    public ReplyID(Content content) {
        this.content = content;
    }
}

