//package com.example.goNotAlone.controller;
//
//import com.example.goNotAlone.model.Role;
//import com.example.goNotAlone.service.GenericService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/role")
//public class RoleController {
//
//    @Autowired
//    private GenericService<Role> genericService;
//
//    @GetMapping(path = "getRoles/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public Role getRolesById(@PathVariable Long id) {
//        return this.genericService.getById(id);
//    }
//
//    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public List<Role> getAllRoles() {
//        return this.genericService.getAll();
//    }
//
//    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public Role createRole(@RequestBody Role ur) {
//        return this.genericService.addG(ur);
//    }
//
//    @DeleteMapping
//    @RequestMapping(path = "deleteRolesById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public void deleteRolesById(@PathVariable Long id) {
//        this.genericService.deleteById(id);
//    }
//
//    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public void deleteAllRoles() {
//        this.genericService.deleteAll();
//    }
//}
