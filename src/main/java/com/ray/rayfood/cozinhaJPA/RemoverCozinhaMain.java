package com.ray.rayfood.cozinhaJPA;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.domain.entities.Cozinha;
import com.ray.domain.repository.CozinhaRepository;
import com.rayllanderson.rayfood.MainApplication;

public class RemoverCozinhaMain {
    
    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE).run(args);
	
	CozinhaRepository cozinha = aContext.getBean(CozinhaRepository.class);
	
	Cozinha c = new Cozinha();
	
	c.setId(1L);
	
	cozinha.remover(c);
	

    }
}
