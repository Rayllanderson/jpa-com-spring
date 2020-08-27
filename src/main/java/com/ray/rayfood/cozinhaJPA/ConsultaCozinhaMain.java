package com.ray.rayfood.cozinhaJPA;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.rayfood.MainApplication;
import com.ray.rayfood.domain.entities.Cozinha;
import com.ray.rayfood.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {
    
    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE).run(args);
	
	CozinhaRepository cozinhas = aContext.getBean(CozinhaRepository.class);
	
	Cozinha cozinha = cozinhas.findById(1L);
	
	System.out.println(cozinha.getNome());

    }
}
