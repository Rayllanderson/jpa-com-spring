package com.ray.rayfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ray.rayfood.domain.entities.Restaurante;
import com.ray.rayfood.domain.exception.EntidadeNaoEncontradaException;
import com.ray.rayfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository repository;
    
    public Restaurante salvar (Restaurante restaurante) {
	return repository.adicionar(restaurante);
    }
    
    public void excluir (Long id) {
	try {
	    repository.remover(id);
	}catch (EmptyResultDataAccessException e) {
	    throw new EntidadeNaoEncontradaException("Não existe um cadastro de restaurante com código " + id);
	}
    }
}
