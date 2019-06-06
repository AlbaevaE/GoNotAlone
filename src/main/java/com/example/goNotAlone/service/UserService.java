package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Application;
import com.example.goNotAlone.model.User;

public interface UserService {
    User add(User user);
    Application addApp(Long userId, Long eventId, String message);
    Application confirmApp(Long userId, Long appId);
    Application click(Long userId, Long appId);

}
