package com.mateus.Filmlog.repository;

import com.mateus.Filmlog.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
