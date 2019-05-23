package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.UserRoles;
import com.example.goNotAlone.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserRolesController.URL_USER_ROLES)
public class UserRolesController {
    public static final String URL_USER_ROLES = "/goNotAlone/UserRoles";

    @Autowired
    private GenericService<UserRoles> genericService;

    @GetMapping(path = "getRoles/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserRoles getRolesById(@PathVariable Long id) {
        return this.genericService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<UserRoles> getAllRoles() {
        return this.genericService.getAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserRoles createRole(@RequestBody UserRoles ur) {
        return this.genericService.addG(ur);
    }

    @DeleteMapping
    @RequestMapping(path = "deleteRolesById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteRolesById(@PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllRoles() {
        this.genericService.deleteAll();
    }
}
