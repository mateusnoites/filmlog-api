package com.mateus.Filmlog.controller;

import com.mateus.Filmlog.model.Movie;
import com.mateus.Filmlog.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movie> getMovies() { return service.getMovies(); }

    @PostMapping
    public Movie saveMovie(@RequestBody Movie movie) { return service.saveMovie(movie); }

    @PutMapping
    public Movie editMovie(@RequestBody Movie movie) { return service.editMovie(movie); }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) { service.deleteMovie(id); }
}
