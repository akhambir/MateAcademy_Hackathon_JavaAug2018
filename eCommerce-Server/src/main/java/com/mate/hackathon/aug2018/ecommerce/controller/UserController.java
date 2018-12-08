package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.model.User;
import com.mate.hackathon.aug2018.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @Autowired
    private UserService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admin/users")
    List<User> getAll() {
        return service.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/admin/users")
    User addUser(@RequestBody User user) {
        return service.create(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admin/users/{id}")
    Optional<User> getUser(@PathVariable Long id) {
        return service.getById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("admin/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        return service.update(user, id);
    }

    @DeleteMapping("admin/user/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }

}