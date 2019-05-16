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
    private String name;
    private String phoneNumber;
    private String email;

    public static class UserBuild {
        private Long id;
        private String name;
        private String phoneNumber;
        private String email;


        public UserBuild(String name) {
            this.name = name;
        }

        public UserBuild withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuild withEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            User user = new User();
            user.name = this.name;
            user.phoneNumber = this.phoneNumber;
            user.email = this.email;
            return user;
        }
    }


}
