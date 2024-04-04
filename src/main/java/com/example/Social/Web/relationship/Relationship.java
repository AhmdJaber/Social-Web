package com.example.Social.Web.relationship;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
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
}
