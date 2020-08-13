package com.ray.rayfood.cozinhaJPA;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.domain.entities.Cozinha;
import com.ray.domain.repository.CozinhaRepository;
import com.rayllanderson.rayfood.MainApplication;

public class AtualizarCozinhaMain {
    
    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE).run(args);
	
	CozinhaRepository cozinha = aContext.getBean(CozinhaRepository.class);
	
	Cozinha c1 = new Cozinha();
	c1.setId(1L);
	c1.setNome("Brasileira");
	
	cozinha.adicionar(c1);
	
	

    }
}
