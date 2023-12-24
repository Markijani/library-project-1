package ru.itgirl.libraryproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirl.libraryproject1.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
