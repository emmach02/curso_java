package com.example.demo.repository;

import com.example.demo.domain.Mueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuebleRepository extends JpaRepository<Mueble, Long> {

}
