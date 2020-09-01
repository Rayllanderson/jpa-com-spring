package com.ray.rayfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ray.rayfood.domain.entities.Estado;
import com.ray.rayfood.domain.exception.EntidadeEmUsoException;
import com.ray.rayfood.domain.exception.EntidadeNaoEncontradaException;
import com.ray.rayfood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

    @Autowired
    EstadoRepository repository;

    public Estado salvar(Estado estado) {
	return this.repository.save(estado);
    }

    public void excluir(Long estadoId) throws EntidadeNaoEncontradaException {
	try {
	    this.repository.deleteById(estadoId);
	} catch (EmptyResultDataAccessException e) {
	    throw new EntidadeNaoEncontradaException(
		    String.format("Não existe um cadastro de estado com código %d", estadoId));
	} catch (DataIntegrityViolationException e) {
	    throw new EntidadeEmUsoException(
		    String.format("Estado de código %d não pode ser removido, pois está em uso", estadoId));
	}
    }
}
