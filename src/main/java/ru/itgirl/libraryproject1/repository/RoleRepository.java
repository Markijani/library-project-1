package ru.itgirl.libraryproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirl.libraryproject1.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
