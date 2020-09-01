package com.ray.rayfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ray.rayfood.domain.entities.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{


}
