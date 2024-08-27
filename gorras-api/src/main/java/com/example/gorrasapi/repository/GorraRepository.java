package com.example.gorrasapi.repository;

import com.example.gorrasapi.model.Gorra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GorraRepository extends JpaRepository<Gorra, Long> {
}
