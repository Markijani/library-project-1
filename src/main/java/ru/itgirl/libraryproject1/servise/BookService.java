package ru.itgirl.libraryproject1.servise;

import ru.itgirl.libraryproject1.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getByNameV1(String name);

    List<BookDto> getByNameV2(String name);

    List<BookDto> getByNameV3(String name);
}
