package fr.remytrohel.wildcircus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.remytrohel.wildcircus.entities.User;
import fr.remytrohel.wildcircus.repositories.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> browse() {
        return userRepository.findAll();
    }
    
    @PostMapping("/users")
    public User add(@ModelAttribute User user) {
        if (userRepository.findByMail(user.getMail()) != null) {
            throw new IllegalArgumentException("Mail already used.");
        }
        return userRepository.save(user);
    }
}