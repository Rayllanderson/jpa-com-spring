package com.ray.rayfood.crud.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ray.rayfood.MainApplication;
import com.ray.rayfood.domain.entities.FormaPagamento;
import com.ray.rayfood.domain.repository.FormaPagamentoRepository;

public class FormaPagamentoCRUD {

    public static void main(String[] args) {
	ApplicationContext aContext = new SpringApplicationBuilder(MainApplication.class).web(WebApplicationType.NONE)
		.run(args);
	FormaPagamentoRepository formaPagamento = aContext.getBean(FormaPagamentoRepository.class);
	
	List<FormaPagamento> todasFormasPagamento = formaPagamento.todas();
	
	//listando todas formasPamanetos
	todasFormasPagamento.forEach(System.out::println);
	
	//buscando por ID
	FormaPagamento f = formaPagamento.porId(3L);
	System.out.println("Forma de pagamento por ID:" + f.getDescricao());
	
	//editando //agora a opção com ID 3 será boleto
	f.setDescricao("Boleto");
	formaPagamento.adicionar(f);
	System.out.println("Novo nome = " + formaPagamento.porId(3L));
	//adicionando
	f = new FormaPagamento();
	f.setDescricao("A PRAZO FDS");
	f = formaPagamento.adicionar(f);
	System.out.println("Nova forma de pagamento = " + f);
	
	//removendo
	formaPagamento.remover(f);
	System.out.println("Adeus forma de pagamento " + f.getDescricao());
    }

}
