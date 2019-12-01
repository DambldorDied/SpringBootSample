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
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/films")
public class FilmController {
    @Autowired
    FilmDAO filmDAO;
    @GetMapping("/all")
    public ModelAndView showMapFilms() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allFilms");
        List<Film> filmsList = filmDAO.findAll();
        modelAndView.addObject("films", filmsList);
        return modelAndView;
    }
    @GetMapping("/add")
    public String showCreateFilm() { return "createFilms"; }
    @GetMapping("/edit")
    public ModelAndView showEditFilm(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById(id);
        modelAndView.addObject("film", film);
        modelAndView.setViewName("editFilm");
        return modelAndView;
    }

    @GetMapping("/delete")
    @Transactional
    public String showDeletePage(@RequestParam Long id) {
        filmDAO.deleteFilmById(id);
        return "deletePage";
    }
    @GetMapping("/onefilm")
    public ModelAndView showOneFilm(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById(id);
        modelAndView.addObject("film", film);
        modelAndView.setViewName("cardFilm");
        return modelAndView;
    }
    @PostMapping("/edit")
    public RedirectView editFilm(Film film) {
        filmDAO.save(film);
        return new RedirectView("/films/all");
    }
    @PostMapping("/add")
    public String addNewFilm(Film film) {
        filmDAO.save(film);
        return "redirect : /films/all";
    }
}
