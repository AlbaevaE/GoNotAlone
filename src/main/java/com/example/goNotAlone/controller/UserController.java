package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.Application;
import com.example.goNotAlone.model.Role;
import com.example.goNotAlone.model.User;
import com.example.goNotAlone.repository.RoleRepository;
import com.example.goNotAlone.repository.UserRepository;
//import com.example.goNotAlone.repository.UserRolesRepository;
import com.example.goNotAlone.service.GenericService;
import com.example.goNotAlone.service.UserServiceImpl;
import com.example.goNotAlone.util.AddApp;
import com.example.goNotAlone.util.Confirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private GenericService<User> genericService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(path = "/getUserById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User getUserById(@PathVariable Long id) {
        return this.genericService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<User> getAllUsers() {
        return this.genericService.getAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User createUser(@RequestBody User u) {
        return this.genericService.addG(u);
    }

    @PostMapping("/registration")
    public User registration(@RequestBody User u) {
        return this.userService.add(u);
    }

    @PostMapping("/addApp")
    public Application addApp(@RequestBody AddApp u) {
        return this.userService.addApp(u.getUserId(),u.getEventId(),u.getMessage());
    }
    @PutMapping("/confirm")
    public Application confirmApp(@RequestBody Confirm u) {
        return this.userService.confirmApp(u.getUserId(), u.getAppId());
    }

    @PutMapping("/click")
    public Application click(@RequestBody Confirm u) {
        return this.userService.click(u.getUserId(), u.getAppId());
    }


    @DeleteMapping
    @RequestMapping(path = "deleteUserById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteUserById(@PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllUsers() {
        this.genericService.deleteAll();
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setIsActive(1);
        Role userRole = roleRepository.findAll().stream().filter(x -> x.getRoleName().equals("ADMIN")).findFirst().get();
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

}
