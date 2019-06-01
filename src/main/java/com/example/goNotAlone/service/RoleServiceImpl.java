package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Event;
import com.example.goNotAlone.model.Role;
import com.example.goNotAlone.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements GenericService<Role> {
    @Autowired
    private RoleRepository RoleRepository;


    @Override
    public Role addG(Role Role) {
        return this.RoleRepository.save(Role);
    }

    @Override
    public Role getById(Long id) {
        return this.RoleRepository.findById(id).get();
    }

    @Override
    public List<Role> getAll() {
        return this.RoleRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.RoleRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.RoleRepository.deleteAll();
    }
}
