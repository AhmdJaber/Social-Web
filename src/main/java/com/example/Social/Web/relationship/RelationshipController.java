package com.example.Social.Web.relationship;

import com.example.Social.Web.user.User;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Relationship")
public class RelationshipController {
    @Autowired
    private RelationshipService relationshipService;

    @GetMapping("allRelationships")
    public List<Relationship> getRelationship(){
        return relationshipService.getAllRelationship();
    }

    @GetMapping("getRelationship/{User1ID}/{User2ID}")
    public Relationship getRelationship(@PathVariable("User1ID") Long user1ID,
                                        @PathVariable("User2ID") Long user2ID){
        return relationshipService.getSomeRelationship(user1ID, user2ID);
    }

    @PostMapping("addRelationship")
    public Relationship addRelationship(@RequestParam Long user1ID,
                                        @RequestParam Long user2ID,
                                        @RequestParam String relationship){
        return relationshipService.addRelationship(user1ID, user2ID, relationship);
    }

    @DeleteMapping("Delete/{RelationshipID}")
    public String deleteRelationship(@PathVariable("RelationshipID") Long id){
        return relationshipService.deleteRelationship(id);
    }

}
