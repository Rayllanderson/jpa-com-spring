package com.ray.rayfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.ray.rayfood.api.model.CozinhasXmlWrapper;
import com.ray.rayfood.domain.entities.Cozinha;
import com.ray.rayfood.domain.repository.CozinhaRepository;

/*
 * UM RECURSO É QUALQUER COISA EXPOXTA NA WEB E PRECISA DE UM URI PRA SER ACESSADO!
 * 
 */

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
    
    @GetMapping (produces = MediaType.APPLICATION_XML_VALUE)//quando soliciar xml, vai cair nesse método
    public CozinhasXmlWrapper listarXml (){
	return new CozinhasXmlWrapper(cozinhaRepository.listar());
    }
    
   // @ResponseStatus(code = HttpStatus.OK) //lançando manualmente um status http como resposta
    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
	Cozinha cozinha = cozinhaRepository.findById(cozinhaId);
	if (cozinha!= null) {
	    //return ResponseEntity.status(HttpStatus.OK).body(cozinha);
	    return ResponseEntity.ok(cozinha); //um shortcut do método acima!
	}
	//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	return ResponseEntity.notFound().build(); //atalho do retorno acima;
    }
    
    @PostMapping //requisições com método POST caíram aqui 
    @ResponseStatus(code = HttpStatus.CREATED) //status 201, created!
    public Cozinha adicionar(@RequestBody Cozinha cozinha) { //pode ser void, mas whatever, eu quero que tenha corpo, entao retornei algo
	return cozinhaRepository.adicionar(cozinha);
    }
    
    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinhaQueVemDoBody){
	Cozinha cozinhaAtual = cozinhaRepository.findById(cozinhaId); //cozinha que está no banco de dados
	if(cozinhaAtual != null) {
//	    cozinhaAtual.setNome(cozinhaQueVemDoBody.getNome()); 
            BeanUtils.copyProperties(cozinhaQueVemDoBody, cozinhaAtual, "id"); //copiando tudo do body pra cozinha que a gente recuperou do BD e ignorando o "ID"
            cozinhaAtual = cozinhaRepository.adicionar(cozinhaAtual);
            return ResponseEntity.ok(cozinhaRepository.adicionar(cozinhaAtual));
	}
	return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
	try {
	    Cozinha cozinha = cozinhaRepository.findById(cozinhaId);
	    if (cozinha!= null) {
		cozinhaRepository.remover(cozinha);
//	    	ResponseEntity.noContent().build();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	    return ResponseEntity.notFound().build();
	}catch (DataIntegrityViolationException e) {
	    return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
    }

    /* Lançando um status 302 com header utilizando ResponseEntity. 
    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar1(@PathVariable("cozinhaId") Long id) {
	
	//instanciando um header
	HttpHeaders header = new HttpHeaders(); 
	
	//adicionando um novo header
	header.add(HttpHeaders.LOCATION, "http://localhost:8080/cozinhas");
	
	//retornando o header
	return ResponseEntity.status(HttpStatus.FOUND).headers(header).build();
    }
    */ 
}
