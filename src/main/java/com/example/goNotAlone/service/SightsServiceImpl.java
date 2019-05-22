package com.example.goNotAlone.service;


import com.example.goNotAlone.model.Sights;
import com.example.goNotAlone.repository.SightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightsServiceImpl implements GenericService<Sights> {
    @Autowired
    private SightsRepository sightsRepository;


    @Override
    public Sights addG(Sights sights) {
        return this.sightsRepository.save(sights);
    }

    @Override
    public Sights getById(Long id) {
        return this.sightsRepository.findById(id).get();
    }

    @Override
    public List<Sights> getAll() {
        return this.sightsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.sightsRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.sightsRepository.deleteAll();
    }
}
