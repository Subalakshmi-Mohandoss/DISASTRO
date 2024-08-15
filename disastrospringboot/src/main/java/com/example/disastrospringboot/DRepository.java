package com.example.disastrospringboot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DRepository extends JpaRepository<DModel, Long> {
    DModel findByEmail(String email);
    DModel findByFirstname(String firstname);

    List<DModel>findAll();
}