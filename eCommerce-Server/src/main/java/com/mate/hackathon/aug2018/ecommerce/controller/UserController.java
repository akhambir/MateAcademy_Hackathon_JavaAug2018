package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.model.Role;
import com.mate.hackathon.aug2018.ecommerce.model.User;
import com.mate.hackathon.aug2018.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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
    public String addUser(
            @RequestParam String email,
            @RequestParam Map<String, String> form,
            @RequestParam String password) {
        User user = service.getByEmail(email);
        if (user != null) {
            return "redirect:/login";
        }
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        service.create(user);
        return "redirect:/users";

    }

    @GetMapping("/admin/users/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {

        return Optional.of(service.getById(id))
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);

    }

    @PutMapping("/admin/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        return Optional.of(service.update(user))
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @DeleteMapping("/admin/users/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}