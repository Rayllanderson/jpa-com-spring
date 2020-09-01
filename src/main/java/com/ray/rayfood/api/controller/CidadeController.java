package com.ray.rayfood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ray.rayfood.domain.entities.Cidade;
import com.ray.rayfood.domain.exception.EntidadeEmUsoException;
import com.ray.rayfood.domain.exception.EntidadeNaoEncontradaException;
import com.ray.rayfood.domain.repository.CidadeRepository;
import com.ray.rayfood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;
    
    @Autowired
    private CadastroCidadeService cadastroCidade;
    
    @GetMapping
    public List <Cidade> listar(){
	return repository.findAll();
    }
    
    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId){
	Optional<Cidade> cidade = repository.findById(cidadeId);
	if (cidade.isEmpty()) {
	    return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(cidade.get());
    }
    
    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Cidade cidade){
	try {
	    return ResponseEntity.status(HttpStatus.CREATED).body(this.cadastroCidade.salvar(cidade));
	}catch (EntidadeNaoEncontradaException e) {
	    return ResponseEntity.badRequest().body(e.getMessage());
	}
    }
    
    @PutMapping("/{cidadeId}")
    public ResponseEntity<?> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade){
	try {
	    Optional<Cidade> cidadeAtual = repository.findById(cidadeId);
	    if(cidadeAtual.isEmpty()) {
		return ResponseEntity.notFound().build();
	    }
	    BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");
	    Cidade cidadeSalva = this.cadastroCidade.salvar(cidadeAtual.get());
	    return ResponseEntity.ok(cidadeSalva);
	}catch (EntidadeNaoEncontradaException e) {
	    return ResponseEntity.badRequest().body(e.getMessage());
	}
    }
    
    @DeleteMapping("/{cidadeId}")
    public ResponseEntity<?> excluir(@PathVariable Long cidadeId){
	try {
	    this.cadastroCidade.remover(cidadeId);
	    return ResponseEntity.noContent().build();
	}catch (EntidadeNaoEncontradaException e) {
	    return ResponseEntity.notFound().build();
	}catch (EntidadeEmUsoException e) {
	    return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
    }
}
