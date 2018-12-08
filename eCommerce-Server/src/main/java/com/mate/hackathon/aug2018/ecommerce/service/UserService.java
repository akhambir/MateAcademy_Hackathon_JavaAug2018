package com.mate.hackathon.aug2018.ecommerce.service;

import com.mate.hackathon.aug2018.ecommerce.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<User> getAll();
    Optional<User> getUserByEmail(String email);
    User addUser(org.springframework.security.core.userdetails.User user);
    User updateUser(org.springframework.security.core.userdetails.User user);
    void deleteUser(org.springframework.security.core.userdetails.User user);


}
