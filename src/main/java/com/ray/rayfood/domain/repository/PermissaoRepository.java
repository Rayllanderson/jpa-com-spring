package com.ray.rayfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ray.rayfood.domain.entities.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long>{


}
