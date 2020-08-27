package com.ray.rayfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ray.rayfood.domain.entities.Cozinha;
import com.ray.rayfood.domain.repository.CozinhaRepository;

@Component //vai ser injetada em algum canto ae kkkk
public class CozinhaRepositoryJPA implements CozinhaRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cozinha> listar() {
	return em.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    @Override
    @Transactional
    public Cozinha adicionar(Cozinha cozinha) {
	return em.merge(cozinha);
    }
    @Override
    public Cozinha findById(Long id) {
	return em.find(Cozinha.class, id);
    }
   
    @Override
    @Transactional
    public void remover(Cozinha c) {
	c = this.findById(c.getId());
	em.remove(c);
    }

}
