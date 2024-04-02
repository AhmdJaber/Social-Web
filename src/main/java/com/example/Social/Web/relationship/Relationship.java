package com.example.Social.Web.relationship;

import com.example.Social.Web.user.User;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table
public class Relationship {
    @EmbeddedId
    @JoinColumn(name = "relation_id")
    private RelationID relationID;

    private RelationType relationType;

    public Relationship() {
    }

    public Relationship(RelationID relationID, RelationType relationType) {
        this.relationID = relationID;
        this.relationType = relationType;
    }

    public RelationID getRelationID() {
        return relationID;
    }

    public void setRelationID(RelationID relationID) {

        this.relationID = relationID;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }


    @Override
    public String toString() {
        return "Relationship{" +
                "relationID=" + relationID +
                ", relationType=" + relationType +
                '}';
    }
}
