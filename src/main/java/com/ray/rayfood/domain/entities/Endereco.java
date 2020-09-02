package com.ray.rayfood.domain.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable//uma classe incorporável// uma parte de alguma entidade, e nao uma entidade em si
//todos os atributos, vao pra tabela que incorporam essa classe
public class Endereco {
    
    @Column(name = "endereco_cep")
    private String cep;
    
    @Column(name = "endereco_logradouro")
    private String logradouro;
    
    @Column(name = "endereco_numero")
    private String numero;
    
    @Column(name = "endereco_complemento")
    private String complemento;
    
    @Column(name = "endereco_bairro")
    private String bairro;
   
    @ManyToOne //muitos bairros possuem uma cidade
    @JoinColumn(name = "endereco_cidade_id")
    private Cidade cidade;
    

}
