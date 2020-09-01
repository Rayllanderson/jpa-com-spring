package com.ray.rayfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ray.rayfood.domain.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{
    
}
