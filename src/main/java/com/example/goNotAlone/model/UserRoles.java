package com.example.goNotAlone.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_roles")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "role_name", nullable = false, length = 100)
    private String roleName;

    public UserRoles() {
    }

    public UserRoles(String roleName) {
        this.roleName = roleName;

    }
}
