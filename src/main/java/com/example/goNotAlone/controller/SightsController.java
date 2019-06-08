package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.Sights;
import com.example.goNotAlone.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sights")
public class SightsController {

    @Autowired
    private GenericService<Sights> genericService;

    @GetMapping(path = "/getSightsById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Sights getSightsById(@PathVariable Long id) {
        return this.genericService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Sights> getAllSights() {
        return this.genericService.getAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Sights createSights(@RequestBody Sights s) {
        return this.genericService.addG(s);
    }

    @DeleteMapping
    @RequestMapping(path = "/deleteSightsById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteSights(@PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAll() {
        this.genericService.deleteAll();
    }

}
