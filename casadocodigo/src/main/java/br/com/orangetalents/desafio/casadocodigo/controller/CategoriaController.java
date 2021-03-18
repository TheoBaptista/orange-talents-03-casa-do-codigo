package br.com.orangetalents.desafio.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.CategoriaResponse;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.CategoriaRequest;
import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;
import br.com.orangetalents.desafio.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {

	private final CategoriaRepository repository;

	
	public CategoriaController(CategoriaRepository repository) {
		this.repository = repository;
		
	}
	
	@PostMapping
	public ResponseEntity<?> cadastraCategoria(@RequestBody @Valid CategoriaRequest formCategoria){
		Categoria categoria = repository.save(formCategoria.toCategoria());
		return ResponseEntity.ok(CategoriaResponse.build(categoria));
				}	
}
