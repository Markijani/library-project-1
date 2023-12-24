package ru.itgirl.libraryproject1.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject1.dto.AuthorDto;
import ru.itgirl.libraryproject1.dto.BookDto;
import ru.itgirl.libraryproject1.dto.GenreDto;
import ru.itgirl.libraryproject1.model.Genre;
import ru.itgirl.libraryproject1.repository.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        return convertEntityToDto(genre);
    }

    private GenreDto convertEntityToDto(Genre genre) {
        List<BookDto> bookDtoList = genre.getBooks().stream()
                .map(book -> BookDto.builder()
                        .genre(book.getGenre().getName())
                        .id(book.getId())
                        .name(book.getName())
                        .authors(book.getAuthors().stream()
                                .map(author -> AuthorDto.builder()
                                        .id(author.getId())
                                        .name(author.getName())
                                        .surname(author.getSurname())
                                        .build())
                                .toList())
                        .build())
                        .toList();
        return GenreDto.builder()
                .books(bookDtoList)
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }
}

