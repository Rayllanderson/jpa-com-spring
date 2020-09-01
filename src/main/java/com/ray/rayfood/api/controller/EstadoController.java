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

import com.ray.rayfood.domain.entities.Estado;
import com.ray.rayfood.domain.exception.EntidadeEmUsoException;
import com.ray.rayfood.domain.exception.EntidadeNaoEncontradaException;
import com.ray.rayfood.domain.repository.EstadoRepository;
import com.ray.rayfood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CadastroEstadoService cadastroEstado;

    @GetMapping
    public List<Estado> listar() {
	return estadoRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    public ResponseEntity<Estado> buscar(@PathVariable Long estadoId) {
	Optional<Estado> estado = estadoRepository.findById(estadoId);
	if (estado.isPresent()) {
	    return ResponseEntity.ok(estado.get());
	}
	return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Estado> salvar(@RequestBody Estado estado) {
	return ResponseEntity.status(201).body(this.cadastroEstado.salvar(estado));
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<?> atualizar(@PathVariable Long estadoId, @RequestBody Estado estado) {
	    Optional<Estado> estadoAtual = this.estadoRepository.findById(estadoId);
	if (estadoAtual.isPresent()) {
	    BeanUtils.copyProperties(estado, estadoAtual.get(), "id");
	    Estado estadoSalvo= this.cadastroEstado.salvar(estadoAtual.get());
	    return ResponseEntity.ok(estadoSalvo);
	}
	return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{estadoId}")
    public ResponseEntity<?> remover(@PathVariable Long estadoId){
	try {
	    this.cadastroEstado.excluir(estadoId);
	    return ResponseEntity.noContent().build();
	}catch (EntidadeNaoEncontradaException e) {
	    return ResponseEntity.notFound().build();
	}catch (EntidadeEmUsoException e) {
	    return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
    }

}
