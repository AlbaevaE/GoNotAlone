package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.Place;
import com.example.goNotAlone.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private GenericService<Place> genericService;

    @GetMapping(path = "/getPlaceById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Place getPlaceById(@PathVariable Long id) {
        return this.genericService.getById(id);
    }

    @GetMapping(path = "/getAllPlaces", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Place> getAllPlaces() {
        return this.genericService.getAll();
    }

    @PostMapping(path = "/addPlace", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Place createPlace(@RequestBody Place p) {
        return this.genericService.addG(p);
    }

    @DeleteMapping
    @RequestMapping(path = "/deletePlaceById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deletePlace(@PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @DeleteMapping(path = "/deleteAllPlaces", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllPlaces() {
        this.genericService.deleteAll();
    }

}
