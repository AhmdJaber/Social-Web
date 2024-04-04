package com.example.Social.Web.reaction;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
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
}
