package com.ray.rayfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ray.rayfood.domain.entities.Cozinha;
import com.ray.rayfood.domain.repository.CozinhaRepository;

//@Controller //indica que essa classe é um controller (oh, não me diga...)
//@ResponseBody - diz que a respostas dos métodos deve ser enviada como resposta da requisição HTTP
//tem que ser exatamente a que o método está pedindo. no caso o método listar, anotado com get mapping

//esses 2 de cima podem ser substituídos por: @RestController
@RestController //também diz que não é um controlador qualquer, e sim um controlador RESTTT BRO
@RequestMapping("/cozinhas") //mapeando a api. as requisições com /cozinhas, vão cair nesse @controller e qual método? ALI>
public class CozinhaController {
    
    @Autowired
    private CozinhaRepository cozinhaRepository;
    
    //GET /cozinhas HTTP/1.1
    //Vai cair diretamente aí
    @GetMapping //koko ni, requisições com método GET caíram aqui 
    public List<Cozinha> listar (){
	return cozinhaRepository.listar();
    }
}
