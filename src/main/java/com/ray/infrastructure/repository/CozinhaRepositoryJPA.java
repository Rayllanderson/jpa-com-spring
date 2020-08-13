package com.ray.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ray.domain.entities.Cozinha;
import com.ray.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryJPA implements CozinhaRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cozinha> todas() {
	return em.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    @Override
    @Transactional
    public Cozinha adicionar(Cozinha cozinha) {
	return em.merge(cozinha);
    }
    @Override
    public Cozinha porId(Long id) {
	return em.find(Cozinha.class, id);
    }
   
    @Override
    @Transactional
    public void remover(Cozinha c) {
	c = this.porId(c.getId());
	em.remove(c);
    }

}
