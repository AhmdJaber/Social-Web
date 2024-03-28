package com.example.Social.Web.reaction;

import com.example.Social.Web.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Reaction")
public class ReactionController {
    @Autowired
    private ReactionRepository reactionRepository;

    @GetMapping("allReactions")
    public List<Reaction> getUsers(){
        return reactionRepository.findAll();
    }

    @PostMapping("addReaction")
    public Reaction addReaction(@RequestBody Reaction reaction){
        return reactionRepository.save(reaction);
    }
}
