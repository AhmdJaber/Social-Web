package com.example.Social.Web.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "userDB")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    private String username;
    private String password;
    private LocalDate dob;
    private String phone;
    private String email;

    public User() {
    }

    public User(Long user_id, String username, String password, LocalDate dob, String phone, String email) {
        this.userId = user_id;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
    }

    public User(String username, String password, LocalDate dob, String phone, String email) {
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
    }
}
