package com.letchic.controller;


import com.letchic.exception.AlreadyAddedException;
import com.letchic.exception.NotFoundException;
import com.letchic.model.User;
import com.letchic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/finduser")
    public User getAllUser(String email, String password) {
        return userService.findByEmailAndPassword(email, password);
    }
    @GetMapping("/finduserwithmessage")
    public List<User> getUserWithMessage() {
        return userService.getUserWithMessage();
    }

    @GetMapping("/findalluser")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @PostMapping("/auth/login")
    public User getUser(@RequestBody User user) throws NotFoundException {
        if (userService.findByEmailAndPassword(user.getEmail(),
                user.getPassword()) == null) throw new NotFoundException();
        return userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    @PostMapping("/auth/register")
    @ResponseStatus(value = HttpStatus.OK, reason = "Successful registration")
    public void creategetUser(@RequestBody User user) throws AlreadyAddedException {
        if (userService.findByEmail(user.getEmail()) != null) {
            throw new AlreadyAddedException();
        } else {
            userService.create(user);
        }
    }
}
