package com.example.goNotAlone.service;

import com.example.goNotAlone.model.AbstractSuggest;
import com.example.goNotAlone.repository.SuggestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestServiceImpl implements GenericService<AbstractSuggest> {
    @Autowired
    private SuggestRepository suggestRepository;


    @Override
    public AbstractSuggest addG(AbstractSuggest suggest) {
        return this.suggestRepository.save(suggest);
    }

    @Override
    public AbstractSuggest getById(Long id) {
        return this.suggestRepository.findById(id).get();
    }

    @Override
    public List<AbstractSuggest> getAll() {
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
