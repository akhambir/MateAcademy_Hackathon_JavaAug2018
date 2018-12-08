package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.model.User;
import com.mate.hackathon.aug2018.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/registration")
    public String registration() {
        return "register";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        Optional<User> userFromDB = userRepository.findByEmail(user.getEmail());
        if (userFromDB != null) {
            model.put("message", "User exist");
            return "register";

        }
        userRepository.save(user);
        return "redirect:/login";

    }
}
