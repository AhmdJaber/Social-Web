package com.example.Social.Web.reaction;

import com.example.Social.Web.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction, ReactionID> {
    Optional<ReactionID> findUserByReactionID(ReactionID reactionID);
}
