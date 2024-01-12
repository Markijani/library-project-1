package ru.itgirl.libraryproject1.servise;

import ru.itgirl.libraryproject1.dto.BookCreateDto;
import ru.itgirl.libraryproject1.dto.BookDto;
import ru.itgirl.libraryproject1.dto.BookUpdateDto;
import ru.itgirl.libraryproject1.model.Book;

import java.util.List;

public interface BookService {
    List<BookDto> getByNameV1(String name);

    List<BookDto> getByNameV2(String name);

    List<BookDto> getByNameV3(String name);
    BookDto createBook(BookCreateDto bookCreateDto);
    BookDto updateBook(BookUpdateDto bookUpdateDto);
    void deleteBook(Long id);
}
