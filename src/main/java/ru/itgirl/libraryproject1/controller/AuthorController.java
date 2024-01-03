package ru.itgirl.libraryproject1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.libraryproject1.dto.AuthorDto;
import ru.itgirl.libraryproject1.servise.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author/{id}")
    AuthorDto getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/author")
    List<AuthorDto> getAuthorsByName(@RequestParam("name") String name) {
        return authorService.getAuthorsByName(name);
    }

    @GetMapping("/author/v1")
    List<AuthorDto> getAuthorsByNameV1(@RequestParam("name") String name) {
        return authorService.getAuthorsByNameV1(name);
    }

    @GetMapping("/author/v2")
    List<AuthorDto> getAuthorsByNameV2(@RequestParam("name") String name) {
        return authorService.getAuthorsByNameV2(name);
    }
}