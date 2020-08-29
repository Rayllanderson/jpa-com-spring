package com.ray.rayfood.api.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ray.rayfood.domain.entities.Cozinha;
import com.ray.rayfood.domain.exception.EntidadeEmUsoException;
import com.ray.rayfood.domain.exception.EntidadeNaoEncontradaException;
import com.ray.rayfood.domain.repository.CozinhaRepository;
import com.ray.rayfood.domain.service.CadastroCozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    // GET /cozinhas HTTP/1.1
    @GetMapping // koko ni, requisições com método GET caíram aqui
    public List<Cozinha> listar() {
	return cozinhaRepository.listar();
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
	Cozinha cozinha = cozinhaRepository.findById(cozinhaId);
	if (cozinha != null) {
	    return ResponseEntity.ok(cozinha);
	}
	return ResponseEntity.notFound().build();
    }

    @PostMapping // requisições com método POST caíram aqui
    @ResponseStatus(code = HttpStatus.CREATED) // status 201, created!
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
	return this.cadastroCozinha.salvar(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinhaQueVemDoBody) {
	Cozinha cozinhaAtual = cozinhaRepository.findById(cozinhaId); // cozinha que está no banco de dados
	if (cozinhaAtual != null) {
	    BeanUtils.copyProperties(cozinhaQueVemDoBody, cozinhaAtual, "id");
	    cozinhaAtual = this.cadastroCozinha.salvar(cozinhaAtual);
	    return ResponseEntity.ok(cozinhaRepository.adicionar(cozinhaAtual));
	}
	return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
	try {
	    this.cadastroCozinha.excluir(cozinhaId);
	    return ResponseEntity.noContent().build();
	} catch (EntidadeNaoEncontradaException e) {
	    return ResponseEntity.notFound().build();
	} catch (EntidadeEmUsoException e) {
	    return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
    }
}
