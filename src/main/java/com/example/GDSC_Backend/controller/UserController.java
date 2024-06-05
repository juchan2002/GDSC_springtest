package com.example.GDSC_Backend.controller;

import com.example.GDSC_Backend.model.User;
import com.example.GDSC_Backend.repository.UserRepository;
import com.example.GDSC_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = new UserService();
    }

    @PostMapping
    @ResponseBody
    public User createUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        return userService.createUser(name, email, password);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id) {
        Optional<User> user = userService.getUser(id);
        return user.orElse(null);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public User updateUser(@PathVariable Long id, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
        return userService.updateUser(id, name, email, password);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
