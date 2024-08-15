package com.example.disastrospringboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormsRepository extends JpaRepository<FormsModel, Long> {
    FormsModel findByName(String name);
}