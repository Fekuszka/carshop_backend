package dev.daniel.carshop.repository;

import dev.daniel.carshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String email);
}
