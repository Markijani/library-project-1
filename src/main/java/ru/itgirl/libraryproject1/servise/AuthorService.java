package ru.itgirl.libraryproject1.servise;

import ru.itgirl.libraryproject1.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
    List<AuthorDto> getAuthorsByName(String name);
    List<AuthorDto> getAuthorsByNameV1(String name);
    List<AuthorDto> getAuthorsByNameV2(String name);
}

