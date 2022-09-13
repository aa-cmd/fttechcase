package com.ican.fttechcase.controller;

import com.ican.fttechcase.model.User;
import com.ican.fttechcase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
