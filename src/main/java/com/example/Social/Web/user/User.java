package com.example.Social.Web.user;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.relationship.Relationship;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "userDB")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long user_id;
    private String username;
    private String password;
    private LocalDate dob;
    private String phone;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Content> contents;

    @OneToMany(mappedBy = "user1_id")
    private List<Relationship> relationships;

    public User() {
    }

    public User(Long user_id,
                String username,
                String password,
                LocalDate dob,
                String phone,
                String email,
                List<Content> contents,
                List<Relationship> relationships) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.contents = contents;
        this.relationships = relationships;
    }

    public User(String username,
                String password,
                LocalDate dob,
                String phone, String email,
                List<Content> contents,
                List<Relationship> relationships) {
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", contents=" + contents +
                ", relationships=" + relationships +
                '}';
    }
}
