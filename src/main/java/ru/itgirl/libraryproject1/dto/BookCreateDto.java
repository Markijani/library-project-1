package ru.itgirl.libraryproject1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirl.libraryproject1.model.Genre;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookCreateDto {
    private String name;
    private Genre genre;
}
