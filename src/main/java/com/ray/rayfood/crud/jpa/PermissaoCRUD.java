package com.ray.rayfood.crud.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.domain.entities.Permissao;
import com.ray.domain.repository.PermissaoRepository;
import com.rayllanderson.rayfood.MainApplication;

public class PermissaoCRUD {

    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE)
		.run(args);
	PermissaoRepository permissao = aContext.getBean(PermissaoRepository.class);
	
	//listando todas as permissões
	List <Permissao> permissoes = permissao.todas();
	permissoes.forEach(System.out::println);
	
	//por id
	Permissao p = permissao.porId(2L);
	System.out.println(p);
	
	//editar
	p.setNome("teste");
	permissao.adicionar(p);
	
	//adicionar
	p = new Permissao();
	p.setNome("Funcionário");
	p.setDescricao("Pode alterar algumas coisas");
	p = permissao.adicionar(p);
	
	//removendo
	permissao.remover(p);
    }

}
