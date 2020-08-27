package com.ray.rayfood.restauranteJPA;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.rayfood.MainApplication;
import com.ray.rayfood.domain.entities.Restaurante;
import com.ray.rayfood.domain.repository.RestauranteRepository;

public class BuscarTodos {
    public static void main(String[] args) {

	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE)
		.run(args);

	RestauranteRepository restaurante = aContext.getBean(RestauranteRepository.class);
	
	List <Restaurante> todosRestaurantes = restaurante.todos();
	
	for (Restaurante r : todosRestaurantes) {
	   System.out.printf("%s - %.2f - %s\n", r.getNome(), r.getTaxaFrete(), r.getCozinha().getNome());
	}
    }
}
