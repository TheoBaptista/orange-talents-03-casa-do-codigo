package br.com.orangetalents.desafio.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.AutorForm;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.AutorResponse;
import br.com.orangetalents.desafio.casadocodigo.domain.Autor;
import br.com.orangetalents.desafio.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private final AutorRepository repository;
	
	public AutorController(AutorRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AutorResponse> cadastraAutor(@Valid @RequestBody AutorForm autorForm){		
		Autor novoAutor = repository.save(autorForm.toAutor());
		return ResponseEntity.ok(AutorResponse.convert(novoAutor));			
	}
	
}
