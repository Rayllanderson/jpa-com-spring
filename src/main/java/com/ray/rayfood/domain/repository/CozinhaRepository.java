package com.ray.rayfood.domain.repository;

import java.util.List;

import com.ray.rayfood.domain.entities.Cozinha;

public interface CozinhaRepository {

    List<Cozinha> listar();
    Cozinha findById(Long id);
    Cozinha adicionar(Cozinha c);
    void remover(Long id);

}
