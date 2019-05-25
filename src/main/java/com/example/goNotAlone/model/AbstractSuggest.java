//package com.example.goNotAlone.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public abstract class AbstractSuggest {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    @OneToMany
//    @JoinColumn(name = "user_id")
//    private User user;
//    @OneToMany
//    @JoinColumn(name = "place_id")
//    private Place place;
//    @OneToMany
//    @JoinColumn(name = "activity_id")
//    private Event activity;
//
//}
