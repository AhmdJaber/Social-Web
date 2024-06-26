package com.example.Social.Web.reaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {
    Reaction findByReactionID(ReactionID reactionID);
}
