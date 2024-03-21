package com.example.Social.Web.user;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.relationship.Relationship;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "userDB")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long user_id;
    private String username;
    private String password;
    private LocalDate dob;
    private Long phone;

    @OneToMany(mappedBy = "user")
    private List<Content> contents;

    @OneToMany(mappedBy = "user1_id")
    private List<Relationship> relationships;

    public User() {
    }

    public User(Long user_id, String username,
                String password,
                LocalDate dob,
                Long phone,
                List<Content> contents,
                List<Relationship> relationships) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.contents = contents;
        this.relationships = relationships;
    }

    public User(String username,
                String password,
                LocalDate dob,
                Long phone, List<Content> contents,
                List<Relationship> relationships) {
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.contents = contents;
        this.relationships = relationships;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                ", phone=" + phone +
                ", contents=" + contents +
                ", relationships=" + relationships +
                '}';
    }
}
