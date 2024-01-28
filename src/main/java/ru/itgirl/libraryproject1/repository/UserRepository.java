package ru.itgirl.libraryproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirl.libraryproject1.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
}
