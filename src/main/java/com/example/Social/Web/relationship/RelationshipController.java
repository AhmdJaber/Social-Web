package com.example.Social.Web.relationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Relationship")
public class RelationshipController {
    @Autowired
    private RelationshipRepository relationshipRepository;

    @GetMapping("allRelations")
    public List<Relationship> allRelations(){
        return relationshipRepository.findAll();
    }

    @PostMapping("addRelation")
    public Relationship addRelation(@RequestBody Relationship relationship){
        return relationshipRepository.save(relationship);
    }
}
