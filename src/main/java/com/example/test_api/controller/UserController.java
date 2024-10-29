package com.example.test_api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {

    private List<String> users = new ArrayList<>();
    @GetMapping
    public List<String> getAllUsers() {
        return users;
    }

    @PostMapping
    public String createUser(@RequestBody Map<String, String> user) {
        String userName = user.get("name");
        users.add(userName);
        return "User created: " + userName;
    }

    @DeleteMapping("/{user}")
    public String deleteUser(@PathVariable String user) {
        if (users.contains(user)) {
            users.remove(user);
            return "User deleted: " + user;
        }
        return "User not found";
    }

    @DeleteMapping("/all")
    public String deleteAllUsers() {
        users.clear();
        return "All users deleted.";
    }
}
