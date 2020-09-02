package com.ray.rayfood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	return restauranteRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long id){
	Optional<Restaurante> res = this.restauranteRepository.findById(id);
	if (res.isPresent()) {
	    return ResponseEntity.ok(res.get());
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
    
    @PutMapping("/{restauranteId}")
    public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
	try {
	    Restaurante restauranteBancoDeDados = this.restauranteRepository.findById(restauranteId).orElse(null);
	    if (restauranteBancoDeDados == null) {
		return ResponseEntity.notFound().build();
	    }
	    BeanUtils.copyProperties(restaurante, restauranteBancoDeDados, "id", "formasPagamento");
	    restauranteBancoDeDados = this.cadastroRestaurante.salvar(restauranteBancoDeDados);
	    return ResponseEntity.ok(restauranteBancoDeDados);
	}catch (EntidadeNaoEncontradaException e) {
	    return ResponseEntity.badRequest().body(e.getMessage());
	}
    }
    
    @PatchMapping("/{restauranteId}")
    public ResponseEntity<?> atualizarParcialmente(@PathVariable Long restauranteId, @RequestBody Map<String, Object> campos){
	Restaurante restauranteAtual = restauranteRepository.findById(restauranteId).orElse(null);
	if (restauranteAtual == null) {
	    return ResponseEntity.notFound().build();
	}
	merge(campos, restauranteAtual);
	
	return this.atualizar(restauranteId, restauranteAtual);
    }

    //tendi foi nada
    private void merge(Map<String, Object> camposOrigem, Restaurante restauranteDestino) {
	ObjectMapper objectMapper = new ObjectMapper();
	Restaurante restauranteOrigem = objectMapper.convertValue(camposOrigem, Restaurante.class);
	
	camposOrigem.forEach((nomePropriedade, valorPropriedade) -> {
	    Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
	    field.setAccessible(true); 
	    Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
	    ReflectionUtils.setField(field, restauranteDestino, novoValor);
	});
    }
    
    /**
     * infelizmente não funciona atualmente, só se apagar tudo antes :/
     */
  /*  @DeleteMapping("/{restauranteId")
    public ResponseEntity<Restaurante> excluir(@PathVariable Long restauranteId){
	try {
	    this.cadastroRestaurante.excluir(restauranteId);
	    return ResponseEntity.noContent().build();
	}catch (EntidadeNaoEncontradaException e) {
	    return ResponseEntity.notFound().build();
	}
    }*/
}
