package com.ray.rayfood.cozinhaJPA;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.domain.entities.Cozinha;
import com.ray.domain.repository.CozinhaRepository;
import com.rayllanderson.rayfood.MainApplication;

public class BuscaCozinhaMain {
    
    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE).run(args);
	
	CozinhaRepository cozinhas = aContext.getBean(CozinhaRepository.class);
	
	List<Cozinha> todasCozinhas = cozinhas.todas();
	
	for (Cozinha c : todasCozinhas) {
	    System.out.println(c.getNome());
	}

    }
}
