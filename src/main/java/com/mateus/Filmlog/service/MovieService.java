package com.mateus.Filmlog.service;

import com.mateus.Filmlog.repository.MovieRepository;
import com.mateus.Filmlog.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getMovies() { return repository.findAll(); }
    public Movie saveMovie(Movie movie) { return repository.save(movie); }
    public Movie editMovie(Movie movie) {
        if (repository.existsById(movie.getId())) {
            Movie newMovie = new Movie(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getReleaseDate(), movie.getCreateDate());
            return repository.save(newMovie);
        }
        return null;
    }
    public void deleteMovie(String id) {
        if (repository.findById(id) != null) {
            repository.deleteById(id);
        }
    }
}
