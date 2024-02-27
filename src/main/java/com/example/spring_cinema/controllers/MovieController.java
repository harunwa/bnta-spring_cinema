package com.example.spring_cinema.controllers;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")

public class MovieController {
    @Autowired
    MovieService movieService;


    @GetMapping
    public ResponseEntity<List<Movie>> getMovie() {
        if (movieService.getMovies() != null) {
            return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(".{id}")
    public ResponseEntity<Movie> getMoviesById(@PathVariable long id) {
        Optional<Movie> checkMovie = movieService.getMovieById(id);
        if (checkMovie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(checkMovie.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovies(@RequestBody Movie movie) {
        movieService.addMovies(movie);
        return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
    }

}