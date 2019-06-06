package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Application;
import com.example.goNotAlone.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplicationService implements GenericService<Application> {
    @Autowired
    private ApplicationRepository repository;

    @Override
    public Application addG(Application application) {
        return repository.save(application);
    }

    @Override
    public Application getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Application> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
