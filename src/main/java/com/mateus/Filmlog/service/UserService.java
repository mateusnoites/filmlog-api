package com.mateus.Filmlog.service;

import com.mateus.Filmlog.model.User;
import com.mateus.Filmlog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() { return repository.findAll(); }
    public User saveUser(User user) { return repository.save(user); }
    public User editUser(User user) {
        if (repository.existsById(user.getId())) {
            return repository.save(user);
        }
        return null;
    }
    public void deleteUser(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
