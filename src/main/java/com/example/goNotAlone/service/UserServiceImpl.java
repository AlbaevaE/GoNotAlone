package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Role;
import com.example.goNotAlone.model.User;
import com.example.goNotAlone.repository.RoleRepository;
import com.example.goNotAlone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements GenericService<User> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public User addG(User user) {
        List<Role> roles = this.roleRepository.findAll();
        user.setIsActive(1);
        user.setPassword(encoder.encode(user.getPassword()));
        boolean isRole = false;
        for(Role r : roles){
            if(r.getRoleName().equals("USER")){
                user.setRoles(new HashSet<Role>(Arrays.asList(r)));
                isRole = true;
            }
        }
        if(!isRole){
            Role role = new Role();
            role.setRoleName("USER");
            user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        }
        userRepository.save(user);
        return user;

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
