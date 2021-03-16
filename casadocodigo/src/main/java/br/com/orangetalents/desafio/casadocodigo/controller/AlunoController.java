package br.com.orangetalents.desafio.casadocodigo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@PostMapping
	public ResponseEntity<?> cadastraAluno(@RequestBody String string){
		
		System.out.println(string);
		
		return ResponseEntity.ok().build();
			
	}
	
}
