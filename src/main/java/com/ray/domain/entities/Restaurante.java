package com.ray.domain.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {
    
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false) // pra especificar que este campo não deve ser nulo. NotNull
    private String nome;
    
    
    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;
    
    @ManyToOne
    //pra mudar o nome, usa o @JoinColumn(name = "fk_cozinha"), provavelmente por ser FK
    private Cozinha cozinha;

    @ManyToOne
    private FormaPagamento formaPagamento;
}
