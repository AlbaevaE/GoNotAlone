package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Role;
import com.example.goNotAlone.model.User;
import com.example.goNotAlone.repository.EventRepository;
import com.example.goNotAlone.repository.RoleRepository;
import com.example.goNotAlone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements GenericService<User>, UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public User addG(User u) {
        User user = userRepository.save(u);
        List<Role> roles = roleRepository.findAll();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        boolean isRole = false;
        for (Role role : roles) {
            if (role.getRoleName().equals("ROLE_USER")) {
                user.setRoles(new HashSet<>(Arrays.asList(role)));
                isRole = true;
                break;
            }
        }
        if (!isRole) {
            Role role = new Role();
            role.setRoleName("ROLE_USER");
            user.setRoles(new HashSet<>(Arrays.asList(role)));
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public boolean login(String email, String password) {
        List<User> users = userRepository.findAll();
        boolean logIn = false;
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                logIn = true;
                break;
            }
        }
        return logIn;
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
