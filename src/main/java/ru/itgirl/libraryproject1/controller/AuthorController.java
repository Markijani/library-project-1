package ru.itgirl.libraryproject1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itgirl.libraryproject1.servise.AuthorService;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    String getAuthorsVew(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }
}
