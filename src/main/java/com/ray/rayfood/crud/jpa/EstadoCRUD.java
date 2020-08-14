package com.ray.rayfood.crud.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.domain.entities.Estado;
import com.ray.domain.repository.EstadoRepository;
import com.rayllanderson.rayfood.MainApplication;

public class EstadoCRUD {

    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE)
		.run(args);
	EstadoRepository estado = aContext.getBean(EstadoRepository.class);
	
	List<Estado> todosEstados = estado.todos();
	todosEstados.forEach(System.out::println);
	
	Estado e = estado.porId(1L);
	System.out.println(e);
	
	e = new Estado();
	e.setNome("Bahia");
	e = estado.adicionar(e);
	
	estado.remover(e);	
    }

}
