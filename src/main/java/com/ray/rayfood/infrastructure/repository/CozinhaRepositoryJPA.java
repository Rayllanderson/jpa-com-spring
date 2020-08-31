package com.ray.rayfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.ray.rayfood.domain.entities.Cozinha;
import com.ray.rayfood.domain.repository.CozinhaRepository;

//@Component //vai ser injetada em algum canto ae kkkk
@Repository
public class CozinhaRepositoryJPA implements CozinhaRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cozinha> listar() {
	return em.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

   /* @Override //nome = nome
    public List<Cozinha> consultarPorNome(String nomeCozinha) {
	return em.createQuery("from Cozinha where nome = :nome", Cozinha.class).setParameter("nome", nomeCozinha).getResultList();
    }*/
    
    @Override //nome contém nome, se eu pesquisar por A, vai listar tudo com A
    public List<Cozinha> consultarPorNome(String nomeCozinha) {
	return em.createQuery("from Cozinha where nome like :nome", Cozinha.class).setParameter("nome", "%" + nomeCozinha + "%").getResultList();
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
    public void remover(Long id) {
	Cozinha c = this.findById(id);
	if(c == null) {
	    throw new EmptyResultDataAccessException(1); //esperava pelo menos uma cozinha
	}
	em.remove(c);
    }
}
