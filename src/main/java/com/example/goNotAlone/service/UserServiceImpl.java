package com.example.goNotAlone.service;

import com.example.goNotAlone.model.User;
import com.example.goNotAlone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements GenericService<User> {
    @Autowired
    private UserRepository userRepository;


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }



    @Override
    public User addG(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.userRepository.deleteAll();
    }


}
