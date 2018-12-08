package com.mate.hackathon.aug2018.ecommerce.service;

import com.mate.hackathon.aug2018.ecommerce.model.User;
import com.mate.hackathon.aug2018.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public User create(User user) {
        return repository.save(user);
    }

    public Optional<User> getByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User update(User newUser, Long id) {
        String email = newUser.getEmail();
        return repository.findByEmail(email)
                .map(user -> {
                    user.setId(id);
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setToken(newUser.getToken());
                    user.setPassword(newUser.getPassword());
                    user.setRoles(newUser.getRoles());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

}




