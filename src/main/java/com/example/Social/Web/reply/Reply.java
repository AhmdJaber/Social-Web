package com.example.Social.Web.reply;

import com.example.Social.Web.content.Content;
import jakarta.persistence.*;

@Entity
@Table
public class Reply {
    @EmbeddedId
    @JoinColumn(name = "reply_id")
    private ReplyID replyID;

    @ManyToOne
    @JoinColumn(name = "reply_parent_id")
    private Content replyParent;

    private String reply_content;

    public Reply() {
    }

    public Reply(ReplyID replyID, Content reply_parent, String reply_content) {
        this.replyID = replyID;
        this.replyParent = reply_parent;
        this.reply_content = reply_content;
    }

    public Reply(Content reply_parent, String reply_content) {
        this.replyParent = reply_parent;
        this.reply_content = reply_content;
    }

    public ReplyID getReplyID() {
        return replyID;
    }

    public void setReplyID(ReplyID replyID) {
        this.replyID = replyID;
    }

    public Content getReplyParent() {
        return replyParent;
    }

    public void setReplyParent(Content replyParent) {
        this.replyParent = replyParent;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyID=" + replyID +
                ", reply_parent=" + replyParent +
                ", reply_content='" + reply_content + '\'' +
                '}';
    }
}
