package com.ray.rayfood.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.ray.rayfood.domain.entities.Cozinha;

import lombok.Data;
import lombok.NonNull;

@JacksonXmlRootElement(localName = "cozinhas") //ou simplesmente @JsonRootName("cozinhas")
@Data
public class CozinhasXmlWrapper {
    
    @JsonProperty("cozinha") //ou simplesmente @JsonProperty("cozinhas)
    @JacksonXmlElementWrapper(useWrapping = false)// pra nao duplicar
    @NonNull///só pra gerar um construtor
    private List<Cozinha> Cozinhas;

}
