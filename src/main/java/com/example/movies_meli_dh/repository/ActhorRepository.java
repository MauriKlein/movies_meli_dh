package com.example.movies_meli_dh.repository;

import com.example.movies_meli_dh.entity.Acthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActhorRepository extends JpaRepository<Acthor, Long> {

    Optional<Acthor> findByDrt(String drt);

}
