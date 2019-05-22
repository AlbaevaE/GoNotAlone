package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.Activity;
import com.example.goNotAlone.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ActivityController.URL_ACTIVITY)
public class ActivityController {
    public static final String URL_ACTIVITY = "/goNotAlone/Activity";
    @Autowired
    private GenericService genericService;

    @GetMapping(path = "getActivityById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Activity getActivityById(@PathVariable Long id) {
        return this.genericService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Activity> getAllActivity() {
        return this.genericService.getAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Activity createActivity(@RequestBody Activity a) {
        return this.genericService.addG(a);
    }

    @DeleteMapping
    @RequestMapping(path = "deleteActivity/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteActivity(@PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllActivity() {
        this.genericService.deleteAll();
    }
}
