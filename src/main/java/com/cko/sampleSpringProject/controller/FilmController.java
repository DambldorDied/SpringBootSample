package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/films")
public class FilmController {
    @GetMapping("/all")
    public String showMapFilms() {
        return "allFilms";
    }
}
