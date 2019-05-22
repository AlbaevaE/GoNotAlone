package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.TravelDeals;
import com.example.goNotAlone.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(TravelDealsController.URL_TRAVEL_DEALS)
public class TravelDealsController {
    public static final String URL_TRAVEL_DEALS = "/goNotAlone/TravelDeals";

    @Autowired
    private GenericService<TravelDeals> genericService;

    @GetMapping(path = "/getTravelDealsById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TravelDeals getTravelDealsById(@PathVariable Long id) {
        return this.genericService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<TravelDeals> getAllTravelDeals() {
        return this.genericService.getAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TravelDeals createTravelDeals(@RequestBody TravelDeals td) {
        return this.genericService.addG(td);
    }

    @DeleteMapping
    @RequestMapping(path = "/deleteTravelDealsById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteTravelDealsById(@PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllTravelDeal() {
        this.genericService.deleteAll();
    }
}
