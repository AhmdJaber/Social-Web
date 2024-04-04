package com.example.Social.Web.reply;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.reaction.Reaction;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
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
}
