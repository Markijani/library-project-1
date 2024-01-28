package ru.itgirl.libraryproject1.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.libraryproject1.servise.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    @RequestMapping("/sign_in")
    public String signIn() {
        return "sign_in";
    }

    @GetMapping
    @RequestMapping("/sign_up")
    public String signUp(
                         @RequestParam(value = "login", defaultValue = "") String username,
                         @RequestParam(value = "pass", defaultValue = "") String password) {
        authService.register(username, password);
        return "ok";
    }
}






