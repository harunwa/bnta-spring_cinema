package com.example.spring_cinema.services;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getMovies(){
        if (!movieRepository.findAll().isEmpty()){
            return movieRepository.findAll();
        }
        return null;
    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public void addMovies(Movie movie){
        movieRepository.save(movie);
    }

}
