package com.example.Social.Web.relationship;

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

    @GetMapping("getRelationship/{RelationshipID}")
    public Relationship getRelationship(@PathParam("RelationshipID") Long relation_id){
        return relationshipService.getSomeRelationship(relation_id);
    }

    @PostMapping("addRelationship")
    public Relationship addRelationship(@RequestBody Relationship relation){
        return relationshipService.addRelationship(relation);
    }

    @DeleteMapping("Delete/{RelationshipID}")
    public String deleteRelationship(@PathVariable("RelationshipID") Long id){
        return relationshipService.deleteRelationship(id);
    }

}
