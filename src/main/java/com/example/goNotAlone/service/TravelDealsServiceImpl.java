package com.example.goNotAlone.service;


import com.example.goNotAlone.model.TravelDeals;

import com.example.goNotAlone.repository.TravelDealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelDealsServiceImpl implements GenericService<TravelDeals> {
    @Autowired
    private TravelDealsRepository travelDealsRepository;


    @Override
    public TravelDeals addG(TravelDeals travelDeals) {
        return this.travelDealsRepository.save(travelDeals);
    }

    @Override
    public TravelDeals getById(Long id) {
        return this.travelDealsRepository.findById(id).get();
    }

    @Override
    public List<TravelDeals> getAll() {
        return this.travelDealsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.travelDealsRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.travelDealsRepository.deleteAll();
    }


}
