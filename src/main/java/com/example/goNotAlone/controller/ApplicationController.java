package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.Application;


import com.example.goNotAlone.service.ApplicationService;

import com.example.goNotAlone.util.AddApp;
import com.example.goNotAlone.util.Confirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;


    @PostMapping("/addApp")
    public Application addApp(@RequestBody AddApp u) {
        return this.applicationService.addApp(u.getUserId(), u.getEventId(), u.getMessage());
    }

    @PutMapping("/confirm")
    public Application confirmApp(@RequestBody Confirm u) {
        return this.applicationService.confirmApp(u.getUserId(), u.getAppId());
    }

    @DeleteMapping("/deleteApp/{id}")
    public void deleteAppById(@PathVariable Long id) {
        this.applicationService.deleteById(id);
    }
}
