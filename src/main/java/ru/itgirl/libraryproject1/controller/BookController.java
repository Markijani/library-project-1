package ru.itgirl.libraryproject1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itgirl.libraryproject1.dto.BookCreateDto;
import ru.itgirl.libraryproject1.dto.BookDto;
import ru.itgirl.libraryproject1.dto.BookUpdateDto;
import ru.itgirl.libraryproject1.servise.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/book")
    List<BookDto> getBooksByName(@RequestParam("name") String name) {
        return bookService.getByNameV1(name);
    }

    @GetMapping("/book/v2")
    List<BookDto> getBooksByNameV2(@RequestParam("name") String name) {
        return bookService.getByNameV2(name);
    }

    @GetMapping("/book/v3")
    List<BookDto> getBooksByNameV3(@RequestParam("name") String name) {
        return bookService.getByNameV3(name);
    }

    @PostMapping("/book/create")
    BookDto createBook(@RequestBody BookCreateDto bookCreateDto) {
        return bookService.createBook(bookCreateDto);
    }

    @PutMapping("/book/update")
    BookDto updateBook(@RequestBody BookUpdateDto bookUpdateDto) {
        return bookService.updateBook(bookUpdateDto);
    }

    @DeleteMapping("/book/delete/{id}")
    void deleteAuthor(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}


