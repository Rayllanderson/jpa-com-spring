package com.ray.rayfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ray.rayfood.domain.entities.Permissao;
import com.ray.rayfood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryJPA implements PermissaoRepository{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Permissao> todas() {
	return em.createQuery("from Permissao", Permissao.class).getResultList();
    }

    @Override
    public Permissao porId(Long id) {
	return em.find(Permissao.class, id);
    }

    @Override
    @Transactional
    public Permissao adicionar(Permissao p) {
	return em.merge(p);
    }

    @Override
    @Transactional
    public void remover(Permissao p) {
	em.remove(this.porId(p.getId()));
    }
}
