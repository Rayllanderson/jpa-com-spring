package com.ray.rayfood.restauranteJPA;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.domain.entities.Restaurante;
import com.ray.domain.repository.RestauranteRepository;
import com.rayllanderson.rayfood.MainApplication;

public class Remover {
    public static void main(String[] args) {

	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE)
		.run(args);

	RestauranteRepository restaurante = aContext.getBean(RestauranteRepository.class);
	
	Restaurante r = new Restaurante();
	
	r.setId(1L);
	
	restaurante.remover(r);
    }
}
