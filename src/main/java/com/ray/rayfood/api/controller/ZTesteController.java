package com.ray.rayfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ray.rayfood.domain.entities.Cozinha;
import com.ray.rayfood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/teste")
public class ZTesteController {

    @Autowired
    private CozinhaRepository repository;
    
//    @GetMapping("/cozinhas/por-nome")
//    public List<Cozinha> cozinhaPorNome(@RequestParam("nome") String nomeCozinha){//parametro da requisição
//	return repository.consultarPorNome(nomeCozinha);
//    }
}
