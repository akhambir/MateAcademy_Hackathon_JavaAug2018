package com.mate.hackathon.aug2018.ecommerce.controller.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mate.hackathon.aug2018.ecommerce.model.User;

public class UserDto extends User {

    @Override
    @JsonIgnore
    public Long getId() {
        return super.getId();
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    @JsonIgnore
    public String getToken() {
        return super.getToken();
    }

    public static UserDto of(User user) {
        UserDto result = new UserDto();
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        result.setEmail(user.getEmail());
        result.setRoles(user.getRoles());
        return result;
    }
}
