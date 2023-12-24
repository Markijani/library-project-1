package ru.itgirl.libraryproject1.servise;

import ru.itgirl.libraryproject1.dto.GenreDto;

public interface GenreService {
    GenreDto getGenreById(Long id);
}
