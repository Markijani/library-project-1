package ru.itgirl.libraryproject1.servise;

import ru.itgirl.libraryproject1.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
}

