package com.example.Social.Web.relationship;

import com.example.Social.Web.reaction.Reaction;
import com.example.Social.Web.reaction.ReactionID;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipService {
    public final RelationshipRepository relationshipRepository;
    @Autowired
    public RelationshipService(RelationshipRepository relationshipRepository){
        this.relationshipRepository = relationshipRepository;
    }

    public List<Relationship> getAllRelationship(){
        return relationshipRepository.findAll();
    }

    public Relationship getSomeRelationship(Long relation_id){
        return relationshipRepository.findById(relation_id).orElseThrow(
                () -> new IllegalStateException("There is no Relationship with ID = " + relation_id)
        );
    }

    public Relationship addRelationship(Relationship relation){
        return relationshipRepository.save(relation);
    }

    public String deleteRelationship(Long relation_id){
        boolean chk = relationshipRepository.existsById(relation_id);
        if (chk){
            relationshipRepository.deleteById(relation_id);
            return "The Relationship with ID = " + relation_id + " has been deleted!";
        }

        return "Action is Done";
    }

    @Transactional
    public String updateRelation(Long relation_id, String relation_type){
        Relationship relationship = relationshipRepository.findById(relation_id).orElseThrow(
                () -> new IllegalStateException("There is no Relationship with ID = " + relation_id)
        );

        relationship.setRelation_type(relation_type);
        return "Action is done";
    }
}
