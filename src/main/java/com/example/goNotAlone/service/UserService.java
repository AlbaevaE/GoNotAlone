package com.example.goNotAlone.service;


import com.example.goNotAlone.model.User;

public interface UserService {
    User registration(User user);

    boolean login(String email, String password);


}
