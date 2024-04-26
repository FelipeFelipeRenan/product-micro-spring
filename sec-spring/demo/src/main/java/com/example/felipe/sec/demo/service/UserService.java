package com.example.felipe.sec.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.felipe.sec.demo.model.User;
import com.example.felipe.sec.demo.repository.UserRepository;

public class UserService {
    
    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(String username, String password){
        User user = new User();

        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return repo.save(user);
    }

    public User getUserByUsername(String username){
        return repo.findByUserName(username);
    }
}
