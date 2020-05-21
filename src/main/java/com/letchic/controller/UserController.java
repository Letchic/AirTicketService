package com.letchic.controller;


import com.letchic.entity.User;
import com.letchic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController  {

    @Autowired
    private UserService userService;

    @GetMapping("/finduser")
    public User getFlight(String email, String password) {
        return userService.findByEmailAndPassword (email,password);
    }
}