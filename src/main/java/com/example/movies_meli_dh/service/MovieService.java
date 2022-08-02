package com.example.movies_meli_dh.service;

import com.example.movies_meli_dh.entity.Acthor;
import com.example.movies_meli_dh.entity.Movie;
import com.example.movies_meli_dh.repository.ActhorRepository;
import com.example.movies_meli_dh.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActhorRepository acthorRepository;

    @Transactional
    public Movie salvarMovie(Movie movie) {
        Optional<Movie> movie1 = movieRepository.findByTitle(movie.getTitle());
        if(movie1.isPresent()){
            movie.setId(movie1.get().getId());
        }else{
            movie.setId(0L);
        }
        for (Acthor a : movie.getActhors()) {
            Optional<Acthor> acthor = acthorRepository.findByDrt(a.getDrt());
            if (acthor.isPresent()) {
                a.setId(acthor.get().getId());
            }
        }
        return movieRepository.save(movie);
    }

    public List<Movie> buscarMovies() {
        return movieRepository.findAll();
    }


}
