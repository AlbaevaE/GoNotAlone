package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Place;
import com.example.goNotAlone.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements GenericService<Place> {
    @Autowired
    private PlaceRepository placeRepository;


    @Override
    public Place addG(Place place) {
        return this.placeRepository.save(place);
    }

    @Override
    public Place getById(Long id) {
        return this.placeRepository.findById(id).get();
    }

    @Override
    public List<Place> getAll() {
        return this.placeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.placeRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.placeRepository.deleteAll();
    }
}
