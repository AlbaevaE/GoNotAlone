package com.example.goNotAlone.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "user_3")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Column(name = "password", nullable = false, unique = true)
    private String password;
    @Column(name = "is_active", nullable = false)
    private int isActive;

    public static class UserBuild {
        private Long id;
        private String name;
        private String phoneNumber;
        private String email;
        private String login;
        private String password;
        private int isActive;

        public UserBuild(String name, String phoneNumber, String email, String login, String password) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.login = login;
            this.password = password;
        }


        public User build() {
            User user = new User();
            user.name = this.name;
            user.phoneNumber = this.phoneNumber;
            user.email = this.email;
            user.login = this.login;
            user.password = this.password;
            user.isActive = this.isActive;
            return user;
        }
    }


}
