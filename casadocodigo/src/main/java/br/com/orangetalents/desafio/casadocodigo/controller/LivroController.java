package br.com.orangetalents.desafio.casadocodigo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

//	private final LivroRepository repository;	
//	
//	public LivroController(LivroRepository repository) {		
//		this.repository = repository;
//	}


	@PostMapping
	public ResponseEntity<?> cadastraLivro(@RequestBody String string){
		
		System.out.println(string);
	
		return ResponseEntity.ok().build();
	}
	
}
