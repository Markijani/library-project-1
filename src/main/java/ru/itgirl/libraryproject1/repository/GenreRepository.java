package ru.itgirl.libraryproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirl.libraryproject1.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}