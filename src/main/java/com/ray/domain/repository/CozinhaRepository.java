package com.ray.domain.repository;

import java.util.List;

import com.ray.domain.entities.Cozinha;

public interface CozinhaRepository {

    List<Cozinha> todas();
    Cozinha porId(Long id);
    Cozinha adicionar(Cozinha c);
    void remover(Cozinha c);

}
