package com.example.Social.Web.relationship;

import com.example.Social.Web.user.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data
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
}
