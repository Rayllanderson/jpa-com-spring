package com.ray.rayfood.crud.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.domain.entities.Cidade;
import com.ray.domain.repository.CidadeRepository;
import com.rayllanderson.rayfood.MainApplication;

public class CidadeCRUD {

    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE)
		.run(args);
	CidadeRepository cidade = aContext.getBean(CidadeRepository.class);
	
	List<Cidade> todasCidades = cidade.todas();
	todasCidades.forEach(System.out::println);
	
	Cidade c = cidade.porId(1L);
	System.out.println(c);
	
	c = new Cidade();
	c.setNome("Cajamar");
	c = cidade.adicionar(c);
	
	cidade.remover(c);	
    }

}
