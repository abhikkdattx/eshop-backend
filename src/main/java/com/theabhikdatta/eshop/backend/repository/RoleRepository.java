package com.theabhikdatta.eshop.backend.repository;

import com.theabhikdatta.eshop.backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
    void deleteByName(String name);
}
