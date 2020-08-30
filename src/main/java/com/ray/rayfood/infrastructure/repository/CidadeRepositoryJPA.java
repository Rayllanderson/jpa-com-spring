package com.ray.rayfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.ray.rayfood.domain.entities.Cidade;
import com.ray.rayfood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryJPA implements CidadeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cidade> listar() {
	return em.createQuery("from Cidade", Cidade.class).getResultList();
    }

    @Override
    @Transactional
    public Cidade adicionar(Cidade Cidade) {
	return em.merge(Cidade);
    }

    @Override
    public Cidade findById(Long id) {
	return em.find(Cidade.class, id);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
	Cidade c = this.findById(id);
	if (c == null) {
	    throw new EmptyResultDataAccessException(1);
	}
	em.remove(c);
    }

}
