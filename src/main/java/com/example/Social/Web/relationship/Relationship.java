package com.example.Social.Web.relationship;

import com.example.Social.Web.user.User;
import jakarta.persistence.*;

@Entity
@Table
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relation_id;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1_id;

    @ManyToOne
    @JoinColumn
    private User user2_id;

    private String relation_type;

    public Relationship() {
    }

    public Relationship(Long relation_id, User user1_id, User user2_id, String relation_type) {
        this.relation_id = relation_id;
        this.user1_id = user1_id;
        this.user2_id = user2_id;
        this.relation_type = relation_type;
    }

    public Relationship(User user1_id, User user2_id, String relation_type) {
        this.user1_id = user1_id;
        this.user2_id = user2_id;
        this.relation_type = relation_type;
    }

    public Long getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(Long relation_id) {
        this.relation_id = relation_id;
    }

    public User getUser1_id() {
        return user1_id;
    }

    public void setUser1_id(User user1_id) {
        this.user1_id = user1_id;
    }

    public User getUser2_id() {
        return user2_id;
    }

    public void setUser2_id(User user2_id) {
        this.user2_id = user2_id;
    }

    public String getRelation_type() {
        return relation_type;
    }

    public void setRelation_type(String relation_type) {
        this.relation_type = relation_type;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "relation_id=" + relation_id +
                ", user1_id=" + user1_id +
                ", user2_id=" + user2_id +
                ", relation_type='" + relation_type + '\'' +
                '}';
    }
}
