package com.ray.rayfood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ray.rayfood.domain.entities.Restaurante;
import com.ray.rayfood.domain.repository.RestaurenteRepositoryQueries;

//precisa ter o Impl, muito importante
@Repository
public class RestauranteRepositoryImpl implements RestaurenteRepositoryQueries {
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public List <Restaurante> find (String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
	var jpql = "from Restaurante where nome like :nome and taxaFrete between :taxaFreteInicial and :taxaFreteFinal";
	return em.createQuery(jpql, Restaurante.class)
		.setParameter("nome", "%" + nome + "%")
		.setParameter("taxaFreteInicial", taxaFreteInicial)
		.setParameter("taxaFreteFinal", taxaFreteFinal)
		.getResultList();
    }

}
