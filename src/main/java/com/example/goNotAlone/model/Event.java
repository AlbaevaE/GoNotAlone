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
@Table(name = "event_1")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    //поиск по месту, дате или категории


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

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

        public Event build() {
            Event event = new Event();
            event.name = this.name;
            event.place = this.place;
            event.description = this.description;
            event.calendar = this.calendar;
            event.category = this.category;
            event.user = this.user;
            event.time = this.time;
            return event;
        }


    }

}
