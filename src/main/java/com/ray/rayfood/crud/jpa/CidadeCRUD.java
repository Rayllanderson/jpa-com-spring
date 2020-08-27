package com.ray.rayfood.crud.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.rayfood.MainApplication;
import com.ray.rayfood.domain.entities.Cidade;
import com.ray.rayfood.domain.repository.CidadeRepository;

public class CidadeCRUD {

    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE)
		.run(args);
	CidadeRepository cidade = aContext.getBean(CidadeRepository.class);
	
	List<Cidade> todasCidades = cidade.listar();
	todasCidades.forEach(System.out::println);
	
	Cidade c = cidade.findById(1L);
	System.out.println(c);
	
	c = new Cidade();
	c.setNome("Cajamar");
	c = cidade.adicionar(c);
	
	cidade.remover(c);	
    }

}
