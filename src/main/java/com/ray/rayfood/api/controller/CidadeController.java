package com.ray.rayfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ray.rayfood.domain.entities.Cidade;
import com.ray.rayfood.domain.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;
    
    @GetMapping
    public List <Cidade> listar(){
	return repository.listar();
    }
    
    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId){
	Cidade cidade = repository.findById(cidadeId);
	if (cidade == null) {
	    return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(cidade);
    }
    
}
