package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Event;
import com.example.goNotAlone.model.UserRoles;
import com.example.goNotAlone.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolesServiceImpl implements GenericService<UserRoles> {
    @Autowired
    private UserRolesRepository userRolesRepository;


    @Override
    public UserRoles addG(UserRoles userRoles) {
        return this.userRolesRepository.save(userRoles);
    }

    @Override
    public UserRoles getById(Long id) {
        return this.userRolesRepository.findById(id).get();
    }

    @Override
    public List<UserRoles> getAll() {
        return this.userRolesRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.userRolesRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.userRolesRepository.deleteAll();
    }
}
