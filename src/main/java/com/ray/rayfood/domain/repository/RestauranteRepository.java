package com.ray.rayfood.domain.repository;

import java.util.List;

import com.ray.rayfood.domain.entities.Restaurante;

public interface RestauranteRepository {

    List<Restaurante> todos();
    Restaurante porId(Long id);
    Restaurante adicionar(Restaurante r);
    void remover(Restaurante r);

}
