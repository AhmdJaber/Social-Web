package com.example.Social.Web.reaction;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Reaction")
public class ReactionController {
    @Autowired
    private ReactionService reactionService;

    @GetMapping("allReaction")
    public List<Reaction> getReactions(){
        return reactionService.getAllReactions();
    }

    @GetMapping("getReaction/{ReactionID}")
    public Reaction getReaction(@PathParam("ReactionID") ReactionID reaction_id){
        return reactionService.getSomeReaction(reaction_id);
    }

    @PostMapping("addReaction/{UserID}/{reactionType}")
    public Reaction addReaction(@PathVariable("UserID") Long userId,
                                @PathVariable("reactionType") String type,
                                @RequestBody Reaction reaction){
        return reactionService.addReaction(userId, reaction, type);
    }

    @DeleteMapping("Delete/{ReactionID}")
    public String deleteReaction(@PathVariable("ReactionID") ReactionID id){
        return reactionService.deleteReaction(id);
    }
}
