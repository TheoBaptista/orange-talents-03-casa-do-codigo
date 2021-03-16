package br.com.orangetalents.desafio.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.ProibeNomeDuplicadoCategoriaValidator;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.CategoriaDto;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.CategoriaForm;
import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;
import br.com.orangetalents.desafio.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private final CategoriaRepository repository;
	private final ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator; 
	
	@InitBinder
	public void init(WebDataBinder binder) {		
		binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
	}
	
	public CategoriaController(CategoriaRepository repository,ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator) {
		this.repository = repository;
		this.proibeNomeDuplicadoCategoriaValidator = proibeNomeDuplicadoCategoriaValidator;
	}
	
	@PostMapping
	public ResponseEntity<?> cadastraCategoria(@RequestBody @Valid CategoriaForm formCategoria){
		Categoria categoria = repository.save(formCategoria.toCategoria());
		return ResponseEntity.ok(CategoriaDto.build(categoria));
				}	
}
