package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.Place;
import com.example.goNotAlone.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PlaceController.URL_PLACE)
public class PlaceController {
    public static final String URL_PLACE = "/goNotAlone/Place";
    @Autowired
    private GenericService<Place> genericService;

    @GetMapping(path = "/getPlaceById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Place getPlaceById(@PathVariable Long id) {
        return this.genericService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Place> getAllPlaces() {
        return this.genericService.getAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Place createPlace(@RequestBody Place p) {
        return this.genericService.addG(p);
    }

    @DeleteMapping
    @RequestMapping(path = "/deletePlaceById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deletePlace(@PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllPlaces() {
        this.genericService.deleteAll();
    }

}
