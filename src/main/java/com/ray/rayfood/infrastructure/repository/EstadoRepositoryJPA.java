package com.ray.rayfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ray.rayfood.domain.entities.Estado;
import com.ray.rayfood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryJPA implements EstadoRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Estado> todos() {
	return em.createQuery("from Estado", Estado.class).getResultList();
    }

    @Override
    @Transactional
    public Estado adicionar(Estado Estado) {
	return em.merge(Estado);
    }
    @Override
    public Estado porId(Long id) {
	return em.find(Estado.class, id);
    }
   
    @Override
    @Transactional
    public void remover(Estado estado) {
	em.remove(porId(estado.getId()));
    }

}
