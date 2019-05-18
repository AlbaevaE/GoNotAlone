package com.example.goNotAlone.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_roles")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "role_name", nullable = false, length = 100)
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserRoles(Long id, String roleName, User user) {
        this.id = id;
        this.roleName = roleName;
        this.user = user;
    }

    public UserRoles(String roleName, User user) {
        this.roleName = roleName;
        this.user = user;
    }
}
