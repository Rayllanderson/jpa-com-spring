package com.ray.rayfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ray.rayfood.domain.entities.Restaurante;
import com.ray.rayfood.domain.exception.EntidadeNaoEncontradaException;
import com.ray.rayfood.domain.repository.RestauranteRepository;
import com.ray.rayfood.domain.service.CadastroRestauranteService;

@RestController()
@RequestMapping(("/restaurantes"))
public class RestauranteController {
    
    @Autowired
    private RestauranteRepository restauranteRepository;
    
    @Autowired
    private CadastroRestauranteService cadastroRestaurante;
    
    @GetMapping
    public List<Restaurante> listar(){
	return restauranteRepository.todos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long id){
	Restaurante res = this.restauranteRepository.porId(id);
	if (res != null) {
	    return ResponseEntity.ok(res);
	}
	return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante){ //o ? indica que vai retornar qualquer coisa, String, restaurante, enfim.
	try{
	    restaurante = cadastroRestaurante.salvar(restaurante);
	    return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
	}catch (EntidadeNaoEncontradaException e) {
	    return ResponseEntity.badRequest().body(e.getMessage());
	}
    }

}
