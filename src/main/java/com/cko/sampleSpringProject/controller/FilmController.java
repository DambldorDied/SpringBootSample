package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/films")
public class FilmController {
    @Autowired
    FilmDAO filmDAO;
    @GetMapping("/all")
    public String showMapFilms() {
        return "allFilms";
    }
    @GetMapping("/add")
    public String showCreateFilm() { return "createFilms"; }
    @GetMapping("/edit")
    public ModelAndView showEditFilm(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Film> optional = filmDAO.findById(id);
        Film film = optional.get();
        modelAndView.addObject("film", film);
        modelAndView.setViewName("editFilm");
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editFilm(Film film) {
        filmDAO.save(film);
        return "allFilms";
    }
    @PostMapping("/add")
    public String addNewFilm(Film film) {
        filmDAO.save(film);
        return "allFilms";
    }
}
