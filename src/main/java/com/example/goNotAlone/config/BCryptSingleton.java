package com.example.goNotAlone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



public class BCryptSingleton {
    private static PasswordEncoder ourInstance;

    public static PasswordEncoder getInstance() {
        if (ourInstance == null)
            ourInstance = new BCryptPasswordEncoder();
        return ourInstance;
    }

    private BCryptSingleton() {
    }
}
