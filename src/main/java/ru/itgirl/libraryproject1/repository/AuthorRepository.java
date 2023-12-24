package ru.itgirl.libraryproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.itgirl.libraryproject1.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
