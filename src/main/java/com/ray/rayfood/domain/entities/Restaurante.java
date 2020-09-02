package com.ray.rayfood.domain.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // pra especificar que este campo não deve ser nulo. NotNull
    private String nome;

    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;

    @ManyToOne
    // pra mudar o nome, usa o @JoinColumn(name = "fk_cozinha"), provavelmente por
    // ser FK
    private Cozinha cozinha;

    @Embedded //essa proproiedade é de um tipo incorporado
    private Endereco endereco;
    
    @JsonIgnore
    @ManyToMany // vai gerar um DER e o nome da tabela DER vai ser restaurante_forma_pagamento,
		// o atributo referente a restaurante
		// nessa tabela (restaurante_forma_pagamento), se chamará: "restaurante_id"
    		// e o nome de forma de pagamento na tabela, vai ser: "forma_pagamento_id"
    @JoinTable(name = "restaurante_forma_pagamento", joinColumns = @JoinColumn(name = "restaurante_id"),
    inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formasPagamento = new ArrayList<>();
 
}
