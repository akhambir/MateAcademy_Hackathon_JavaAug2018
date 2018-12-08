package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.model.User;
import com.mate.hackathon.aug2018.ecommerce.repository.UserRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User addUser(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping("/users/{id}")
    Optional<User> getUser(@PathVariable Long id) {
        return repository.findById(id);

    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User user, @PathVariable Long id) {
        return repository.findById(id)
                .map(user1 -> {
                    user1.setFirstName(user.getFirstName());
                    user1.setLastName(user.getLastName());
                    user1.setRoles(user.getRoles());
                    return repository.save(user1);
                })
                .orElseGet(() -> {
                    user.setId(id);
                    return repository.save(user);
                });
    }

    @DeleteMapping("/user/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}