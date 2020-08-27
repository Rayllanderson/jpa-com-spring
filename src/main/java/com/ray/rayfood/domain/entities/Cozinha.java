package com.ray.rayfood.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName("cozinha") //mesma coisa do @JsonProperty, mas agora altera o nome da classe la. Nao funfa em JSON, json nao tem essa propriedade como no XML
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cozinha {
    
   // @JsonProperty("código")
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
   // @JsonProperty("titulo") //especificando na "saída" do json que o valor "nome" será alterado para "titulo"
    //sem @JsonProperty: "nome": "japonesa" // com o @JsonProperty: "titulo": "japonesa". got it?
    //@JsonIgnore //na "saída" não vai aparecer ele; OBS: com o @JsonProperty, nao funciona, pois o @JsonProperty tem prioridade
    @Column(length = 30)
    private String nome;
}
