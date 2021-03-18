package br.com.orangetalents.desafio.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.AutorDto;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.AutorForm;
import br.com.orangetalents.desafio.casadocodigo.domain.Autor;
import br.com.orangetalents.desafio.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private final AutorRepository repository;
	
	/*
	 * Parte que era necessária antes de fazer a anotação de @constraint 
	 * 
	 * private final ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator; //validadores costumizados do spring
	
	@InitBinder // utilizado sempre antes de executar os metodos do controller para executar configurações adicionais
	public void init(WebDataBinder binder) {		
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}
	*/
	
	public AutorController(AutorRepository repository) {
		this.repository = repository;
		//this.proibeEmailDuplicadoAutorValidator = proibeEmailDuplicadoAutorValidator ;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> cadastraAutor(@Valid @RequestBody AutorForm autorForm){	
		
		System.out.println(autorForm.getEmail()+ autorForm.getNome() + autorForm.getDescricao());
		
		Autor novoAutor = repository.save(autorForm.toAutor());
		return ResponseEntity.ok(AutorDto.buildAutor(novoAutor));			
	}
	
}
