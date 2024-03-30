package com.example.Social.Web.reaction;

import com.example.Social.Web.reply.Reply;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionService {
    public final ReactionRepository reactionRepository;
    @Autowired
    public ReactionService(ReactionRepository reactionRepository){
        this.reactionRepository = reactionRepository;
    }

    public List<Reaction> getAllReactions(){
        return reactionRepository.findAll();
    }

    public Reaction getSomeReaction(ReactionID reaction_id){
        return reactionRepository.findById(reaction_id).orElseThrow(
                () -> new IllegalStateException("There is no Reaction with ID = " + reaction_id)
        );
    }

    public Reaction addReaction(Reaction reaction){
        return reactionRepository.save(reaction);
    }

    public String deleteReaction(ReactionID reaction_id){
        boolean chk = reactionRepository.existsById(reaction_id);
        if (chk){
            reactionRepository.deleteById(reaction_id);
            return "The Reaction with ID = " + reaction_id + " has been deleted!";
        }

        return "Action is Done";
    }

    @Transactional
    public String updateReaction(ReactionID reactionID, String reaction_type){
        Reaction reaction = reactionRepository.findById(reactionID).orElseThrow(
                () -> new IllegalStateException("There is no Reaction with ID = " + reactionID)
        );

        reaction.setReaction_type(reaction_type);
        return "Action is done";
    }
}
