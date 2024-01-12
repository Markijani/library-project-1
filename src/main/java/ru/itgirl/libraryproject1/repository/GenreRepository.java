package ru.itgirl.libraryproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirl.libraryproject1.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}