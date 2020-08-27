package com.ray.rayfood.restauranteJPA;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.rayfood.MainApplication;
import com.ray.rayfood.domain.entities.Restaurante;
import com.ray.rayfood.domain.repository.RestauranteRepository;

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
