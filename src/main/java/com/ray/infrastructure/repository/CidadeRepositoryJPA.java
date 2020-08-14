package com.ray.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ray.domain.entities.Cidade;
import com.ray.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryJPA implements CidadeRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cidade> todas() {
	return em.createQuery("from Cidade", Cidade.class).getResultList();
    }

    @Override
    @Transactional
    public Cidade adicionar(Cidade Cidade) {
	return em.merge(Cidade);
    }
    @Override
    public Cidade porId(Long id) {
	return em.find(Cidade.class, id);
    }
   
    @Override
    @Transactional
    public void remover(Cidade estado) {
	em.remove(porId(estado.getId()));
    }

}
