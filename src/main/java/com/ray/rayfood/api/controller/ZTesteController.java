package com.ray.rayfood.api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ray.rayfood.domain.entities.Cozinha;
import com.ray.rayfood.domain.entities.Restaurante;
import com.ray.rayfood.domain.repository.CozinhaRepository;
import com.ray.rayfood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class ZTesteController {

    @Autowired
    private CozinhaRepository cRepository;
    
    @Autowired
    private RestauranteRepository rRepository;
    
    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhaPorNome(@RequestParam("nome") String nomeCozinha){//@@RequestParam = parametro da requisição
	return cRepository.findTodasByNome(nomeCozinha);
    }
    
    @GetMapping("/cozinhas/por-nome-ou-letra")
    public List<Cozinha> cozinhaPorNomeOuLetra(String nome){//parametro da requisição opcional
	return cRepository.findTodasByNomeContaining(nome);
    }
    
    @GetMapping("/restaurantes/taxa-frete-entre")
    public List<Restaurante> taxaFreteEntre(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
	return rRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
    }
    
    @GetMapping("/restaurantes/por-nome1")
    public List<Restaurante> restaurantePorNome1(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
	return rRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
    }
    
    //mesma coisa do método acima, but com nome diferente, podendo ter essas 2 possibilidades
    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> restaurantePorNome(String nome, Long cozinhaId){
	return rRepository.consultaPorNome(nome, cozinhaId);
    }
    
    
    
    
}
