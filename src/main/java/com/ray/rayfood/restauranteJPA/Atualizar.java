package com.ray.rayfood.restauranteJPA;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.domain.entities.Restaurante;
import com.ray.domain.repository.RestauranteRepository;
import com.rayllanderson.rayfood.MainApplication;

public class Atualizar {
    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE)
		.run(args);
	RestauranteRepository restaurante = aContext.getBean(RestauranteRepository.class);
	Restaurante r1 = new Restaurante();
	r1.setId(1L);
	r1.setNome("xahaha");
	r1.setTaxaFrete(new BigDecimal(7.97));
	restaurante.adicionar(r1);
    }
}
