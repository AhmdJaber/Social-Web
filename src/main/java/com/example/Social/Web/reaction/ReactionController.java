package com.example.Social.Web.reaction;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.content.ContentRepository;
import com.example.Social.Web.user.User;
import com.example.Social.Web.user.UserRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Reaction")
public class ReactionController {
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReactionService reactionService;

    @GetMapping("allReaction")
    public List<Reaction> getReactions(){
        return reactionService.getAllReactions();
    }

    @GetMapping("getReaction/{ReactionID}")
    public Reaction getReaction(@PathParam("ReactionID") Long id){
        return reactionService.getSomeReaction(id);
    }

    @PostMapping("addReaction/{UserID}/{reactionType}")
    public Reaction addReaction(@PathVariable("UserID") Long userId,
                                @PathVariable("reactionType") String type,
                                @RequestBody Reaction reaction){
        return reactionService.addReaction(userId, reaction, type);
    }

    @DeleteMapping("deleteReaction/{ReactionID}")
    public String deleteReaction(@PathVariable("ReactionID") Long id){
        return reactionService.deleteReaction(id);
    }
}
