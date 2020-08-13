package com.ray.rayfood.restauranteJPA;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.domain.entities.Restaurante;
import com.ray.domain.repository.RestauranteRepository;
import com.rayllanderson.rayfood.MainApplication;

public class BuscarTodos {
    public static void main(String[] args) {

	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE)
		.run(args);

	RestauranteRepository restaurante = aContext.getBean(RestauranteRepository.class);
	
	List <Restaurante> todosRestaurantes = restaurante.todos();
	
	for (Restaurante r : todosRestaurantes) {
	    System.out.println(r);
	}
    }
}
