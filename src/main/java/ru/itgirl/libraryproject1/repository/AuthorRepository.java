package ru.itgirl.libraryproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.itgirl.libraryproject1.model.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor <Author> {
   List<Author> findAllAuthorsByName(String name);
   @Query(nativeQuery = true, value = "SELECT * FROM AUTHOR WHERE name = ?")
   List<Author> findAllAuthorsByNameBySql(String name);
}
