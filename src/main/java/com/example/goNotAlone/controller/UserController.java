package com.example.goNotAlone.controller;


import com.example.goNotAlone.model.User;

import com.example.goNotAlone.service.GenericService;
import com.example.goNotAlone.service.UserService;



import com.example.goNotAlone.util.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    //  @Autowired
//    private GenericService<User> genericService;
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private UserServiceImpl userService;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @GetMapping(path = "/getUserById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public User getUserById(@PathVariable Long id) {
//        return this.genericService.getById(id);
//    }
//
//    @GetMapping(path = "/getAllUsers",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public List<User> getAllUsers() {
//        return this.genericService.getAll();
//    }
//
//    @PostMapping(path = "",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public User createUser(@RequestBody User u) {
//        return this.genericService.addG(u);
//    }
//
//    @PostMapping("/registration")
//    public User registration(@RequestBody User u) {
//        return this.userService.add(u);
//    }
//
////    @PostMapping("/addApp")
////    public Application addApp(@RequestBody AddApp u) {
////        return this.userService.addApp(u.getUserId(),u.getEventId(),u.getMessage());
////    }
////    @PutMapping("/confirm")
////    public Application confirmApp(@RequestBody Confirm u) {
////        return this.userService.confirmApp(u.getUserId(), u.getAppId());
////    }
//
////    @PutMapping("/click")
////    public Application click(@RequestBody Confirm u) {
////        return this.userService.click(u.getUserId(), u.getAppId());
////    }
//
//
//    @DeleteMapping
//    @RequestMapping(path = "deleteUserById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public void deleteUserById(@PathVariable Long id) {
//        this.genericService.deleteById(id);
//    }
//
//    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public void deleteAllUsers() {
//        this.genericService.deleteAll();
//    }
//
//    public User addUser(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setIsActive(1);
//        Role userRole = roleRepository.findAll().stream().filter(x -> x.getRoleName().equals("ADMIN")).findFirst().get();
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//        return userRepository.save(user);
//    }
//
//}

    @Autowired
    private GenericService<User> userService;
    @Autowired
    private UserService usService;



    @Secured("ROLE_USER")
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<? extends Object> logIn(@RequestBody Login login) {
        try {
            if (usService.login(login.getEmail(), login.getPassword())) {
                return new ResponseEntity<>("successfully logged in", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("no such user", HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/getAll")
    public ResponseEntity<List<? extends Object>> getUsers() {
        try {
            return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getById/{id}")
    public ResponseEntity<? extends Object> getUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<? extends Object> saveUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.addG(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<? extends Object> deleteUserById(@PathVariable Long id) {
        try {
            this.userService.deleteById(id);
            return new ResponseEntity<>("Deleted user", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/deleteAll")
    public ResponseEntity<? extends Object> deleteAllUsers() {
        try {
            this.userService.deleteAll();
            return new ResponseEntity<>("Deleted all users", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }
}
