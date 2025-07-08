package com.mateus.Filmlog.controller;

import com.mateus.Filmlog.model.User;
import com.mateus.Filmlog.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getUsers() { return service.getUsers(); }

    @PostMapping
    public User saveUser(@RequestBody User user) { return service.saveUser(user); }

    @PutMapping
    public User editUser(@RequestBody User user) { return service.editUser(user); }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) { service.deleteUser(id); }
}
