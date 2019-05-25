package com.example.goNotAlone.model;


import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "sights")
public class Sights {//достопримечательности
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;

    public Sights() {
    }

    public Sights(String name, Place place) {
        this.name = name;
        this.place = place;
    }
}
