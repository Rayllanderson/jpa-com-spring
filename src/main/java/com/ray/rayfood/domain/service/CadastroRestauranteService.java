package com.ray.rayfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ray.rayfood.domain.entities.Cozinha;
import com.ray.rayfood.domain.entities.Restaurante;
import com.ray.rayfood.domain.exception.EntidadeNaoEncontradaException;
import com.ray.rayfood.domain.repository.CozinhaRepository;
import com.ray.rayfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;
    
    @Autowired
    private CozinhaRepository cozinhaRepository;
    
    public Restaurante salvar (Restaurante restaurante) {
	Long cozinhaId = restaurante.getCozinha().getId();
	Cozinha c = cozinhaRepository.findById(cozinhaId);
	if (c == null) {
	    throw new EntidadeNaoEncontradaException("Não existe cadastro de cozinha com id " + cozinhaId);
	}
	restaurante.setCozinha(c);
	return restauranteRepository.adicionar(restaurante);
    }
    
    public void excluir (Long id) {
	try {
	    restauranteRepository.remover(id);
	}catch (EmptyResultDataAccessException e) {
	    throw new EntidadeNaoEncontradaException("Não existe um cadastro de restaurante com código " + id);
	}
    }
}
