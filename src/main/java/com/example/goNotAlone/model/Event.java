package com.example.goNotAlone.model;

import com.example.goNotAlone.enums.Category;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;


@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;
    private String description;//описание
    private Calendar calendar;//время и дата
    private Category category; //категория мероприятия
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime time;
    //поиск по месту или дате или названию

    public static class EventBuild {
        private Long id;
        private String name;
        private Place place;
        private String description;
        private Calendar calendar;
        private Category category;
        private User user;
        private LocalDateTime time;


        public EventBuild(String name, Place place) {
            this.name = name;
            this.place = place;
            this.time = time;

        }

        public EventBuild withDescription(String description) {
            this.description = description;
            return this;
        }

        public EventBuild withCalendar(Calendar calendar) {
            this.calendar = calendar;
            return this;
        }

        public EventBuild withCategory(Category category) {
            this.category = category;
            return this;
        }

        public EventBuild withUser(User user) {
            this.user = user;
            return this;
        }

    }

}
