package com.ray.rayfood.domain.repository;

import java.util.List;

import com.ray.rayfood.domain.entities.Cidade;

public interface CidadeRepository {

    List<Cidade> listar();

    Cidade findById(Long id);

    Cidade adicionar(Cidade c);

    void removeById(Long id);
}
