package com.mate.hackathon.aug2018.ecommerce.service;

import com.mate.hackathon.aug2018.ecommerce.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getByEmail(String email);

    User create(User user);

    User update(User user,Long id);

    void delete(Long id);

    List<User> getAll();

    Optional<User> getById(Long id);
}
