package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/users")
    List<com.mate.hackathon.aug2018.ecommerce.model.User> getAll() {
        return service.getAll();
    }

    @PostMapping("/users")
    com.mate.hackathon.aug2018.ecommerce.model.User addUser(@RequestBody com.mate.hackathon.aug2018.ecommerce.model.User user) {
        return null;
    }

    @GetMapping("/users/{id}")
    Optional<com.mate.hackathon.aug2018.ecommerce.model.User> getUser(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/user/{id}")


    @DeleteMapping("/user/{id}")
    void deleteEmployee(@PathVariable Long id) {
    }

}