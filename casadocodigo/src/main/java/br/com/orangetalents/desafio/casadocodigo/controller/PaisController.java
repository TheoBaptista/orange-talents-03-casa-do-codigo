package br.com.orangetalents.desafio.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.PaisRequest;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.PaisResponse;
import br.com.orangetalents.desafio.casadocodigo.domain.Pais;
import br.com.orangetalents.desafio.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("api/pais")
public class PaisController {

	private final PaisRepository repository;

	public PaisController(PaisRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PaisResponse> cadastraPais(@RequestBody @Valid PaisRequest paisRequest){
		
		Pais pais = repository.save(paisRequest.toPais());
		
		return ResponseEntity.ok(PaisResponse.build(pais));
	}

}
