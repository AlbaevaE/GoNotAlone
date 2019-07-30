package com.example.goNotAlone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "user1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    @NotEmpty(message = "*Please provide your name")
    private String name;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
    @Column(name = "email", nullable = false)
    @Email(message = "*Please provide a valid Email")
//    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Column(name = "password", nullable = false, unique = true)
    @Length(min = 5, message = "*Your password must have at least 5 characters")
//    @NotEmpty(message = "*Please provide your password")

    private String password;

    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Set<Role> roles;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public static class UserBuild {
        private Long id;
        private String name;
        private String phoneNumber;
        private String email;
        private String password;
        private int active;
        private Set<Role> roles;

        public UserBuild(String name, String phoneNumber, String email, String password) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.password = password;
        }


        public UserBuild withRole(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            User user = new User();
            user.name = this.name;
            user.phoneNumber = this.phoneNumber;
            user.email = this.email;
            user.password = this.password;
            user.active = this.active;
            user.roles = this.roles;
            return user;
        }
    }

}
