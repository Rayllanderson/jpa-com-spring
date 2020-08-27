package com.ray.rayfood.domain.repository;

import java.util.List;

import com.ray.rayfood.domain.entities.Estado;

public interface EstadoRepository {

    List<Estado> todos();

    Estado porId(Long id);

    Estado adicionar(Estado estado);

    void remover(Estado estado);

}
