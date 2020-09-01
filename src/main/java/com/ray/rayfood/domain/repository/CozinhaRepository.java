package com.ray.rayfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ray.rayfood.domain.entities.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> { //<Repositorio da entidade, Tipo do ID da entidade>
//vai criar uma classe em tempo de excecução
    
//	List<Cozinha> nome(String nome); //nome = propriedade em Cozinha, ou seja, exatamente igual o atributo nome. private String nome
//   	List<Cozinha> findByNome(String nome);	//mesma coisa do acima.
    	List<Cozinha> findTodasByNome(String nome); //posso colocar qualquer coisa no meio de find e By. find é um prefixo e By é onde delimita o atributo
    	List<Cozinha> findTodasByNomeContaining(String nome); //o nome do método vira meio que a expressão. aq é procurando qualquer cozinha q tenha o "nome"
}
