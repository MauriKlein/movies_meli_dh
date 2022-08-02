package com.example.movies_meli_dh.controller;

import com.example.movies_meli_dh.entity.Movie;
import com.example.movies_meli_dh.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping()
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.salvarMovie(movie));
    }

    @GetMapping("all")
    public ResponseEntity<List<Movie>> findAllMovies(){
        return ResponseEntity.ok(movieService.buscarMovies());

    }


}
