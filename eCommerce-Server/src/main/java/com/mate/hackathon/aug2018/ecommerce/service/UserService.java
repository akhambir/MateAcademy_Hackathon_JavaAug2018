package com.mate.hackathon.aug2018.ecommerce.service;

import com.mate.hackathon.aug2018.ecommerce.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    User create(User user);

    User update(User user);

    void delete(Long id);

    List<User> getAll();

    Optional<User> getById(Long id);
}
