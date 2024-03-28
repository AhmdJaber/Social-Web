package com.example.Social.Web.reply;

import com.example.Social.Web.content.Content;
import jakarta.persistence.*;

@Entity
@Table
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reply_id;

    @OneToOne
    @JoinColumn(name = "content_id")
    private Content content;

    @ManyToOne
    @JoinColumn(name = "reply_parent_id")
    private Content reply_parent;

    public Reply() {
    }

    public Reply(Long reply_id, Content content, Content reply_parent) {
        this.reply_id = reply_id;
        this.content = content;
        this.reply_parent = reply_parent;
    }

    public Reply(Content content, Content reply_parent) {
        this.content = content;
        this.reply_parent = reply_parent;
    }

    public Long getReply_id() {
        return reply_id;
    }

    public void setReply_id(Long reply_id) {
        this.reply_id = reply_id;
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
                "reply_id=" + reply_id +
                ", content=" + content +
                ", reply_parent=" + reply_parent +
                '}';
    }
}
