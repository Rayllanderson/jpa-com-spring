package com.ray.rayfood.restauranteJPA;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.rayfood.MainApplication;
import com.ray.rayfood.domain.entities.Restaurante;
import com.ray.rayfood.domain.repository.RestauranteRepository;

public class Inserir {

    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE)
		.run(args);

	RestauranteRepository restaurante = aContext.getBean(RestauranteRepository.class);
	
	Restaurante r1 = new Restaurante();
	r1.setNome("hue hue br br restaurantes");
	r1.setTaxaFrete(new BigDecimal(1.99));

	restaurante.adicionar(r1);
    }
}
