package com.example.Social.Web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long user_id){
        return userRepository.findById(user_id).orElseThrow(
                () -> new IllegalStateException("There is no User with ID = " + user_id)
        );
    }

    public User addUser(User user){
        if (user.getUsername() == null){
            throw new IllegalStateException("Empty username is not valid!");
        }
        if (user.getPassword() == null){
            throw new IllegalStateException("Empty password is not valid!");
        }
        if (user.getDob() == null){
            throw new IllegalStateException("Empty date of birth is not valid!");
        }

        Optional<User> cur = userRepository.findUserByEmail(user.getEmail());
        if (cur.isPresent()){
            throw new IllegalStateException("This Email is already used");
        }

        return userRepository.save(user);
    }

    public String updateName(Long user_id, String username){
        User user = userRepository.findById(user_id).orElseThrow(
                () -> new IllegalStateException("There is no User with ID = " + user_id)
        );

        user.setUsername(username);
        return "Action is done";
    }

    public String updatePassword(Long user_id, String password){
        User user = userRepository.findById(user_id).orElseThrow(
                () -> new IllegalStateException("There is no User with ID = " + user_id)
        );

        user.setPassword(password);
        return "Action is done";
    }

    public String updateDate(Long user_id, LocalDate dob){
        User user = userRepository.findById(user_id).orElseThrow(
                () -> new IllegalStateException("There is no User with ID = " + user_id)
        );

        user.setDob(dob);
        return "Action is done";
    }

    public String updatePhone(Long user_id, String phone){
        User user = userRepository.findById(user_id).orElseThrow(
                () -> new IllegalStateException("There is no User with ID = " + user_id)
        );

        user.setPhone(phone);
        return "Action is done";
    }

    public String updateEmail(Long user_id, String email){
        User user = userRepository.findById(user_id).orElseThrow(
                () -> new IllegalStateException("There is no User with ID = " + user_id)
        );

        Optional<User> cur = userRepository.findUserByEmail(email);
        if (cur.isPresent()){
            throw new IllegalStateException("The email is already used!");
        }

        user.setEmail(email);
        return "Action is done";
    }

    public String deleteUser(Long user_id){
        boolean chk = userRepository.existsById(user_id);
        if (chk){
            userRepository.deleteById(user_id);
            return "The User with ID = " + user_id + " has been deleted!";
        }

        return "There is not user with id = " + user_id;
    }
}
