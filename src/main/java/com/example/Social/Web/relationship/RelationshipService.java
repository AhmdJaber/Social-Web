package com.example.Social.Web.relationship;

import com.example.Social.Web.user.User;
import com.example.Social.Web.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipService {
    @Autowired
    private UserRepository userRepository;
    private final RelationshipRepository relationshipRepository;
    @Autowired
    public RelationshipService(RelationshipRepository relationshipRepository){
        this.relationshipRepository = relationshipRepository;
    }

    public List<Relationship> getAllRelationship(){
        return relationshipRepository.findAll();
    }

    public Relationship getSomeRelationship(Long user1ID, Long user2ID){
        User user1 = userRepository.findById(user1ID).orElseThrow(
                () -> new IllegalStateException("There is no user with ID = " + user1ID)
        );
        User user2 = userRepository.findById(user2ID).orElseThrow(
                () -> new IllegalStateException("There is no user with ID = " + user2ID)
        );
        if (user1.getUserId() > user2.getUserId()){
            User temp = user1;
            user1 = user2;
            user2 = temp;
        }

        RelationID curRelation = new RelationID(user1, user2);
        return relationshipRepository.findByRelationID(curRelation);
    }

    public Relationship addRelationship(Long user1ID, Long user2ID, String relation){
        User user1 = userRepository.findById(user1ID).orElseThrow(
                () -> new IllegalStateException("There is no user with ID = " + user1ID)
        );
        User user2 = userRepository.findById(user2ID).orElseThrow(
                () -> new IllegalStateException("There is no user with ID = " + user2ID)
        );

        RelationType relationType = RelationType.valueOf(relation.toUpperCase());
        RelationID relationID = new RelationID(user1, user2);
        Relationship relationship = new Relationship(relationID, relationType);
        return relationshipRepository.save(relationship);
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
    public String updateRelation(Long relation_id, RelationType relation_type){
        Relationship relationship = relationshipRepository.findById(relation_id).orElseThrow(
                () -> new IllegalStateException("There is no Relationship with ID = " + relation_id)
        );

        relationship.setRelationType(relation_type);
        return "Action is done";
    }
}
