package com.example.goNotAlone.model;

import com.example.goNotAlone.enums.ApplicationStatus;
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
@Table(name = "event_proposal")
public class EventProposals {//предложения по мероприятиям
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;
    private String description;//описание
    private Calendar calendar;//время и дата
    private Category category; //категория мероприятия
    private LocalDateTime time;//вермя подачи предложения
    private ApplicationStatus status;//статус рассмотрения предложения

    public static class ProposalsBuild {
        private Long id;
        private String name;
        private User user;
        private Place place;
        private String description;
        private Calendar calendar;
        private Category category;
        private LocalDateTime time;
        private ApplicationStatus status;

        public ProposalsBuild(String name, User user, Place place) {
            this.name = name;
            this.user = user;
            this.place = place;
            this.time = time;
        }

        public ProposalsBuild withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProposalsBuild withCalendar(Calendar calendar) {
            this.calendar = calendar;
            return this;
        }

        public ProposalsBuild withCategory(Category category) {
            this.category = category;
            return this;
        }

        public EventProposals build() {
            EventProposals proposals = new EventProposals();
            proposals.name = this.name;
            proposals.user = this.user;
            proposals.place = this.place;
            proposals.description = this.description;
            proposals.calendar = this.calendar;
            proposals.category = this.category;
            proposals.status = this.status;
            return proposals;
        }
    }
    //здесь нужен метод одобрения заявки через сеттер


}
