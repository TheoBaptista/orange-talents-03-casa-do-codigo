package br.com.orangetalents.desafio.casadocodigo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.desafio.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("api/pais")
public class PaisController {

	private final PaisRepository repository;

	public PaisController(PaisRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	public ResponseEntity<?> cadastraPais(@RequestBody String nome){
		
		System.out.println(nome);
		
		return ResponseEntity.ok().build();
				

	}

}
