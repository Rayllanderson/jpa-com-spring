package com.ray.rayfood.domain.repository;

import java.util.List;

import com.ray.rayfood.domain.entities.Permissao;

public interface PermissaoRepository {

    List<Permissao> todas();
    Permissao porId(Long id);
    Permissao adicionar(Permissao p);
    void remover(Permissao p);

}
