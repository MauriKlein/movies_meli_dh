package com.example.movies_meli_dh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Acthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String drt;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "acthors")
    @JsonIgnoreProperties("acthors")
    private List<Movie> movies;
}
