package com.example.Social.Web.reaction;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table
public class Reaction {
    @EmbeddedId
    @JoinColumn(name = "reaction_id")
    private ReactionID reactionID;

    private String reaction_type;

    public Reaction() {
    }

    public Reaction(ReactionID reactionID, String reaction_type) {
        this.reactionID = reactionID;
        this.reaction_type = reaction_type;
    }

    public ReactionID getReactionID() {
        return reactionID;
    }

    public void setReactionID(ReactionID reactionID) {
        this.reactionID = reactionID;
    }

    public String getReaction_type() {
        return reaction_type;
    }

    public void setReaction_type(String reaction_type) {
        this.reaction_type = reaction_type;
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "reactionID=" + reactionID +
                ", reaction_type='" + reaction_type + '\'' +
                '}';
    }
}
