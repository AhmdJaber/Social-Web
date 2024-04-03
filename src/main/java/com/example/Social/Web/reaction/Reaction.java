package com.example.Social.Web.reaction;

import jakarta.persistence.*;

@Entity
@Table
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Embedded
    @JoinColumn(name = "reaction_id")
    private ReactionID reactionID;

    private ReactionType reactionType;

    public Reaction() {
    }

    public Reaction(Long id, ReactionID reactionID, ReactionType reactionType) {
        Id = id;
        this.reactionID = reactionID;
        this.reactionType = reactionType;
    }

    public Reaction(ReactionID reactionID, ReactionType reactionType) {
        this.reactionID = reactionID;
        this.reactionType = reactionType;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
                "Id=" + Id +
                ", reactionID=" + reactionID +
                ", reactionType=" + reactionType +
                '}';
    }
}
