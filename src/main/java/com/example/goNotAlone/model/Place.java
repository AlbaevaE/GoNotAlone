package com.example.goNotAlone.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String place;//описание

    // долгота ширина
//функционал подтверждения
    //сортировка по дате
    //место должно принадлежать юзеру
    public Place() {
    }

    public Place(String place) {
        this.place = place;
    }
}
