package com.example.Social.Web.reply;

import com.example.Social.Web.content.Content;
import jakarta.persistence.*;

@Entity
@Table
public class Reply {
    @Id
    @OneToOne
    @JoinColumn(name = "reply_id")
    private Content content;

    @ManyToOne
    @JoinColumn
    private Content reply_parent;

    public Reply() {
    }

    public Reply(Content content, Content reply_parent) {
        this.content = content;
        this.reply_parent = reply_parent;
    }

    public Reply(Content reply_parent) {
        this.reply_parent = reply_parent;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Content getReply_parent() {
        return reply_parent;
    }

    public void setReply_parent(Content reply_parent) {
        this.reply_parent = reply_parent;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "content=" + content +
                ", reply_parent=" + reply_parent +
                '}';
    }
}
