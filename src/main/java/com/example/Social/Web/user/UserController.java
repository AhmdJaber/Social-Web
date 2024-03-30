package com.example.Social.Web.user;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "User")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/all users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{UserID}")
    public User getUser(@PathVariable("UserID") Long user_id){
        return userService.getUser(user_id);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/UpdateUsername/{UserID}")
    public String updateUsername(
            @PathVariable("UserID") Long user_id,
            @RequestParam(required = true) String username){
        return userService.updateName(user_id, username);
    }

    @PutMapping("UpdateEmail/{UserID}")
    public String UpdateEmail(
            @PathVariable("UserID") Long user_id,
            @RequestParam(required = true) String email){
        return userService.updateEmail(user_id, email);
    }

    @PutMapping("UpdatePassword/{UserID}")
    public String updatePassword(
            @PathVariable("UserID") Long user_id,
            @RequestParam(required = true) String password){
        return userService.updatePassword(user_id, password);
    }

    @PutMapping("UpdateDate/{UserID}")
    public String updateDate(
            @PathVariable("UserID") Long user_id,
            @RequestParam(required = true) LocalDate dob){
        return userService.updateDate(user_id, dob);
    }

    @PutMapping("UpdatePhone/{UserID}")
    public String UpdatePhone(
            @PathVariable("UserID") Long user_id,
            @RequestParam(required = true) String phone){
        return userService.updatePhone(user_id, phone);
    }

    @DeleteMapping("DeleteUser/{UserID}")
    public String DeleteUser(@PathVariable("UserID") Long user_id){
        return userService.deleteUser(user_id);
    }
}
