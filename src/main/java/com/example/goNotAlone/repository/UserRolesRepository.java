package com.example.goNotAlone.repository;

import com.example.goNotAlone.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRolesRepository")
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
    UserRoles findByRole(String role);
}
