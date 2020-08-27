package com.ray.rayfood.cozinhaJPA;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.rayfood.MainApplication;
import com.ray.rayfood.domain.entities.Cozinha;
import com.ray.rayfood.domain.repository.CozinhaRepository;

public class BuscaCozinhaMain {
    
    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE).run(args);
	
	CozinhaRepository cozinhas = aContext.getBean(CozinhaRepository.class);
	
	List<Cozinha> todasCozinhas = cozinhas.listar();
	
	for (Cozinha c : todasCozinhas) {
	    System.out.println(c.getNome());
	}

    }
}
