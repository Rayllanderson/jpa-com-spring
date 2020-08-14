package com.ray.domain.repository;

import java.util.List;

import com.ray.domain.entities.Cidade;

public interface CidadeRepository {

    List<Cidade> todas();

    Cidade porId(Long id);

    Cidade adicionar(Cidade c);

    void remover(Cidade c);
}
