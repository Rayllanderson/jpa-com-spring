package com.ray.rayfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ray.rayfood.domain.entities.Cozinha;
import com.ray.rayfood.domain.exception.EntidadeEmUsoException;
import com.ray.rayfood.domain.exception.EntidadeNaoEncontradaException;
import com.ray.rayfood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
	return cozinhaRepository.save(cozinha);
    }

    public void excluir(Long cozinhId) {
	try {
	    cozinhaRepository.deleteById(cozinhId);
	} catch (EmptyResultDataAccessException e) {
	    throw new EntidadeNaoEncontradaException("Não existe um cadastro de cozinha com código " + cozinhId);
	} catch (DataIntegrityViolationException e) {
	    throw new EntidadeEmUsoException(
		    String.format("Cozinha de código %d não pode ser removida, pois está em uso.", cozinhId));
	}
    }
}
