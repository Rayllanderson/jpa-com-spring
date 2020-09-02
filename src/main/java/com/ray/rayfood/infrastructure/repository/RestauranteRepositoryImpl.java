package com.ray.rayfood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.ray.rayfood.domain.entities.Restaurante;
import com.ray.rayfood.domain.repository.RestaurenteRepositoryQueries;

//precisa ter o Impl, muito importante
@Repository
public class RestauranteRepositoryImpl implements RestaurenteRepositoryQueries {
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public List <Restaurante> find (String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
	var jpql = new StringBuilder();
	var parametros = new HashMap<String, Object>();
	jpql.append("from Restaurante where 0 = 0 ");
	
	if(StringUtils.hasLength(nome)) {
	    jpql.append("and nome like :nome ");
	    parametros.put("nome", "%" + nome + "%");
	}
	
	if(taxaFreteInicial != null) {
	    jpql.append("and taxaFrete >= :taxaFreteInicial ");
	    parametros.put("taxaFreteInicial", taxaFreteInicial);
	}
	
	if(taxaFreteFinal != null) {
	    jpql.append("and taxaFrete <= :taxaFreteFinal ");
	    parametros.put("taxaFreteFinal", taxaFreteFinal);
	}
	
	TypedQuery<Restaurante> query =  em.createQuery(jpql.toString(), Restaurante.class);
	
	parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
	
	return query.getResultList();
    }

}
