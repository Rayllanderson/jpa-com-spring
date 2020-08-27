package com.ray.rayfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ray.rayfood.domain.entities.Restaurante;
import com.ray.rayfood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryJPA implements RestauranteRepository {
   
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Restaurante> todos() {
	return em.createQuery("from Restaurante", Restaurante.class).getResultList();
    }

    @Override
    public Restaurante porId(Long id) {
	return em.find(Restaurante.class, id);
    }

    @Override
    @Transactional
    public Restaurante adicionar(Restaurante r) {
	return em.merge(r);
    }

    @Override
    @Transactional
    public void remover(Restaurante c) {
	em.remove(porId(c.getId()));
    }

}
