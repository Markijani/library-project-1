package ru.itgirl.libraryproject1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirl.libraryproject1.model.Genre;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookUpdateDto {
    private Long id;
    private String name;
    private Genre genre;
}
