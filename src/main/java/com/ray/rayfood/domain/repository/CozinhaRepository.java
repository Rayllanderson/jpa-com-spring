package com.ray.rayfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ray.rayfood.domain.entities.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> { //<Repositorio da entidade, Tipo do ID da entidade>
//vai criar uma classe em tempo de excecução
    
    
//    List<Cozinha> consultarPorNome(String nome);

}
