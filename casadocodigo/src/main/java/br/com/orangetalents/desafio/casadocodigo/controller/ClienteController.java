package br.com.orangetalents.desafio.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.DocumentoValidator;
import br.com.orangetalents.desafio.casadocodigo.configuration.validation.EstadoValidator;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.ClienteRequest;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.ClienteResponse;
import br.com.orangetalents.desafio.casadocodigo.domain.Cliente;
import br.com.orangetalents.desafio.casadocodigo.domain.Estado;
import br.com.orangetalents.desafio.casadocodigo.domain.Pais;
import br.com.orangetalents.desafio.casadocodigo.repository.ClienteRepository;
import br.com.orangetalents.desafio.casadocodigo.repository.EstadoRepository;
import br.com.orangetalents.desafio.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

	private final ClienteRepository repository;
	private final EstadoRepository estadoRepo;
	private final PaisRepository paisRepo;
	private final EstadoValidator estadoValidator;
	private final DocumentoValidator documentoValidator;
	
	public ClienteController(ClienteRepository repository, EstadoRepository estadoRepo, PaisRepository paisRepo,
			EstadoValidator estadoValidator, DocumentoValidator documentoValidator) {
		super();
		this.repository = repository;
		this.estadoRepo = estadoRepo;
		this.paisRepo = paisRepo;
		this.estadoValidator = estadoValidator;
		this.documentoValidator = documentoValidator;
	}


	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoValidator,documentoValidator);
	}
	
	
	@Transactional
	@PostMapping
	public ResponseEntity<ClienteResponse> cadastraCliente(@RequestBody @Valid ClienteRequest novoCliente){

		
		Pais pais = paisRepo.findByNome(novoCliente.getNomePais().toUpperCase());
		Cliente cliente = novoCliente.toCliente(pais);
		
		
		
		if(novoCliente.getNomeEstado() != null) {
		 Estado estado = estadoRepo.findByNome(novoCliente.getNomeEstado().toUpperCase());
		 cliente.setEstado(estado);		 
		}
		
		repository.save(cliente);
		
		return ResponseEntity.ok(ClienteResponse.build(cliente));
	}	
	
}
