package com.mate.hackathon.aug2018.ecommerce.controller;

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
    @GetMapping("/users")
    List<com.mate.hackathon.aug2018.ecommerce.model.User> getAll() {
        return service.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/users")
    com.mate.hackathon.aug2018.ecommerce.model.User addUser(@RequestBody com.mate.hackathon.aug2018.ecommerce.model.User user) {
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users/{id}")
    Optional<com.mate.hackathon.aug2018.ecommerce.model.User> getUser(@PathVariable Long id) {
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/user/{id}")

    @DeleteMapping("/user/{id}")
    void deleteEmployee(@PathVariable Long id) {
    }

}