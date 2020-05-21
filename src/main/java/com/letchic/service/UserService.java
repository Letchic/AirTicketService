package com.letchic.service;

import com.letchic.entity.User;
import com.letchic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email,password);
    }

}
