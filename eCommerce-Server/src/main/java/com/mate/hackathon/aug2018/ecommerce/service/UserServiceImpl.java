package com.mate.hackathon.aug2018.ecommerce.service;

import com.mate.hackathon.aug2018.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .map(this::toUserDetails)
                .orElseGet(() -> User.builder().disabled(true).build());
    }

    public List<com.mate.hackathon.aug2018.ecommerce.model.User> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<com.mate.hackathon.aug2018.ecommerce.model.User> getUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public com.mate.hackathon.aug2018.ecommerce.model.User addUser(User user) {
        return null;
    }

    @Override
    public com.mate.hackathon.aug2018.ecommerce.model.User updateUser(User user) {
        return null;
    }

    public com.mate.hackathon.aug2018.ecommerce.model.User updateUser(com.mate.hackathon.aug2018.ecommerce.model.User user) {
//        return repository.findById(id)
//                .map(user1 -> {
//                    user1.setFirstName(user.getFirstName());
//                    user1.setLastName(user.getLastName());
//                    user1.setRoles(user.getRoles());
//                    return repository.save(user1);
//                })
//                .orElseGet(() -> {
//                    user.setId(id);
//                    return repository.save(user);
//                });
        return null;
    }

    public void deleteUser(User user) {
    }

    private UserDetails toUserDetails(com.mate.hackathon.aug2018.ecommerce.model.User user) {
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }
}




