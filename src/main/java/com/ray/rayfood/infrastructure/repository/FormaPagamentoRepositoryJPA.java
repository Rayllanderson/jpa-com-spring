package com.ray.rayfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ray.rayfood.domain.entities.FormaPagamento;
import com.ray.rayfood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryJPA implements FormaPagamentoRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<FormaPagamento> todas() {
	return em.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
    }

    @Override
    public FormaPagamento porId(Long id) {
	return em.find(FormaPagamento.class, id);
    }

    @Transactional
    @Override
    public FormaPagamento adicionar(FormaPagamento umaFormaPagamento) {
	return em.merge(umaFormaPagamento);
    }

    @Transactional
    @Override
    public void remover(FormaPagamento umaFormaPagamento) {
	em.remove(porId(umaFormaPagamento.getId()));
    }
    
    
}
