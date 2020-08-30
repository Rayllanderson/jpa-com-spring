package com.ray.rayfood.domain.repository;

import java.util.List;

import com.ray.rayfood.domain.entities.Estado;

public interface EstadoRepository {

    List<Estado> listar();

    Estado findById(Long id);

    Estado adicionar(Estado estado);

    void removeById(Long id);

}
