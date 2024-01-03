package ru.itgirl.libraryproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.itgirl.libraryproject1.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> , JpaSpecificationExecutor<Book> {
        List<Book> findAllByName(String name);
        @Query(nativeQuery = true, value = "SELECT * FROM BOOK WHERE name = ?")
        List<Book> findAllByNameBySql(String name);
}
