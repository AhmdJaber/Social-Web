package com.example.Social.Web.relationship;

import com.example.Social.Web.user.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
@Embeddable
public class RelationID implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2;

    public RelationID() {
    }

    public RelationID(User user1, User user2) {
        User minUser = user1, maxUser = user2;
        if (minUser.getUserId() > maxUser.getUserId()){
            User temp = minUser;
            minUser = maxUser;
            maxUser = temp;
        }

        this.user1 = minUser;
        this.user2 = maxUser;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }


    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    @Override
    public String toString() {
        return "RelationOwners{" +
                "user1=" + user1 +
                ", user2=" + user2 +
                '}';
    }
}
