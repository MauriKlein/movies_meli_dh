package com.example.movies_meli_dh.service;

import com.example.movies_meli_dh.entity.Acthor;
import com.example.movies_meli_dh.entity.Movie;
import com.example.movies_meli_dh.repository.ActhorRepository;
import com.example.movies_meli_dh.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ActhorService {

    @Autowired
    private ActhorRepository acthorRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Acthor salvarActhor(Acthor acthor) {
        if(acthorRepository.findByDrt(acthor.getDrt()).isPresent()){
            acthor.setId(acthorRepository.findByDrt(acthor.getDrt()).get().getId());
        }
        return acthorRepository.save(acthor);
    }

    public List<Acthor> buscarActhors() {
        return acthorRepository.findAll();
    }
}
