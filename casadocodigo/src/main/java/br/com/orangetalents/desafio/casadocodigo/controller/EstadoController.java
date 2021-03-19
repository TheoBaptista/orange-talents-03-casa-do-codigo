package br.com.orangetalents.desafio.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.EstadoRequest;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.EstadoResponse;
import br.com.orangetalents.desafio.casadocodigo.domain.Estado;
import br.com.orangetalents.desafio.casadocodigo.domain.Pais;
import br.com.orangetalents.desafio.casadocodigo.repository.EstadoRepository;
import br.com.orangetalents.desafio.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

	private final EstadoRepository estadoRepository;
	private final PaisRepository paisRepository;
	
	public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		this.estadoRepository = estadoRepository;
		this.paisRepository = paisRepository;
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastraEstado(@RequestBody @Valid EstadoRequest novoEstado){
		
		Pais pais = paisRepository.findByNome(novoEstado.getNomePais().toUpperCase());
		Estado estado = estadoRepository.save(novoEstado.toEstado(pais));
		
		return ResponseEntity.ok(EstadoResponse.build(estado));
	}	
}
