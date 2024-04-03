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

    private ReactionType reactionType;

    public Reaction() {
    }

    public Reaction(ReactionID reactionID, ReactionType reaction_type) {
        this.reactionID = reactionID;
        this.reactionType = reaction_type;
    }

    public ReactionID getReactionID() {
        return reactionID;
    }

    public void setReactionID(ReactionID reactionID) {
        this.reactionID = reactionID;
    }

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "reactionID=" + reactionID +
                ", reaction_type='" + reactionType + '\'' +
                '}';
    }
}
