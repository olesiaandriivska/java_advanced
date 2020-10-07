package com.javaadvanced.controller;


import com.javaadvanced.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @PostMapping
    public User addUser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return users.removeIf(user -> user.getId() == id);
    }


    @GetMapping(value = "/{id}")
    public User getById(@PathVariable int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No user"));
    }

    @PutMapping(value = "/{id}")
    public boolean updateUser(@PathVariable int id, @RequestBody User newUser) {
        boolean isDeleted = users.removeIf(user -> user.getId() == id);
        System.out.println(newUser);

        if (isDeleted) {
            newUser.setId(id);
            users.add(newUser);
        }
        return isDeleted;

    }


}
