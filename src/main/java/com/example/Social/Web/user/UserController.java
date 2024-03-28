package com.example.Social.Web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "User")
public class UserController {
    @Autowired
    public UserRepository userRepository;

    @GetMapping("all users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("addUser")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
