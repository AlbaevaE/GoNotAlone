package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.Sights;
import com.example.goNotAlone.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sights")
public class SightsController {

    @Autowired
    private GenericService<Sights> genericService;

    @Secured("ROLE_USER")
    @GetMapping(path = "/getSightsById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Sights getSightsById(@PathVariable Long id) {
        return this.genericService.getById(id);
    }

    @Secured("ROLE_USER")
    @GetMapping(path = "/getAllSights", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Sights> getAllSights() {
        return this.genericService.getAll();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/addSights", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Sights createSights(@RequestBody Sights s) {
        return this.genericService.addG(s);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping
    @RequestMapping(path = "/deleteSightsById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteSights(@PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(path = "/deleteAllSights", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAll() {
        this.genericService.deleteAll();
    }

}
