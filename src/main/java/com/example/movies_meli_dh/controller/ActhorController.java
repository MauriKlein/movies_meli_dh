package com.example.movies_meli_dh.controller;

import com.example.movies_meli_dh.entity.Acthor;
import com.example.movies_meli_dh.entity.Movie;
import com.example.movies_meli_dh.service.ActhorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/acthor")
public class ActhorController {
    @Autowired
    private ActhorService acthorService;

    @PostMapping()
    public ResponseEntity<Acthor> createMovie(@RequestBody Acthor acthor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(acthorService.salvarActhor(acthor));
    }

    @GetMapping("all")
    public ResponseEntity<List<Acthor>> findAllActhors(){
        return ResponseEntity.ok(acthorService.buscarActhors());
    }


}
