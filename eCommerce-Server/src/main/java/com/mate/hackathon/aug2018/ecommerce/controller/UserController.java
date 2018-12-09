package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.model.User;
import com.mate.hackathon.aug2018.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getAll() {
        return Optional.of(service.getAll())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return Optional.of(service.create(user))
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/admin/users/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {

        return Optional.of(service.getById(id))
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);

    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return service.getByEmail(user.getEmail())
                .map(u -> { user.setId(u.getId()); return u; })
                .map(u -> { user.setToken(u.getToken()); return u; })
                .map(u -> { user.setPassword(u.getPassword()); return user; })
                .map(service::update)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound():: build);
    }

    @DeleteMapping("/admin/users/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}