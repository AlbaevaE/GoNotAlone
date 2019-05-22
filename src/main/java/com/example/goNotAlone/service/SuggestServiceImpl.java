package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Suggest;
import com.example.goNotAlone.repository.SuggestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestServiceImpl implements GenericService<Suggest> {
    @Autowired
    private SuggestRepository suggestRepository;


    @Override
    public Suggest addG(Suggest suggest) {
        return this.suggestRepository.save(suggest);
    }

    @Override
    public Suggest getById(Long id) {
        return this.suggestRepository.findById(id).get();
    }

    @Override
    public List<Suggest> getAll() {
        return this.suggestRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.suggestRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.suggestRepository.deleteAll();
    }
}
