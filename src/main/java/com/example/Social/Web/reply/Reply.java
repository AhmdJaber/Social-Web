package com.example.Social.Web.reply;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.reaction.Reaction;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Reply {
    @EmbeddedId
    @JoinColumn(name = "reply_id")
    private ReplyID replyID;

    @ManyToOne
    @JoinColumn(name = "reply_parent_id")
    private Content replyParent;

    @OneToMany
    @JoinColumn(name = "replyReactions")
    private List<Reaction> reactions = new ArrayList<>();

    private String reply_content;

    public Reply() {
    }

    public Reply(ReplyID replyID, Content replyParent, List<Reaction> reactions, String reply_content) {
        this.replyID = replyID;
        this.replyParent = replyParent;
        this.reactions = reactions;
        this.reply_content = reply_content;
    }

    public Reply(Content replyParent, List<Reaction> reactions, String reply_content) {
        this.replyParent = replyParent;
        this.reactions = reactions;
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

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
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
                ", replyParent=" + replyParent +
                ", reactions=" + reactions +
                ", reply_content='" + reply_content + '\'' +
                '}';
    }
}
