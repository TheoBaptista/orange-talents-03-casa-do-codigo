package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import br.com.orangetalents.desafio.casadocodigo.domain.Pais;

public class PaisResponse {

	private String nome;
	private Long id;
	
	
	public PaisResponse(String nome, Long id) {
		super();
		this.nome = nome;
		this.id = id;
	}
	
	
	
	public String getNome() {
		return nome;
	}



	public Long getId() {
		return id;
	}

	public static PaisResponse build(Pais pais) {
		return new PaisResponse(pais.getNome(),pais.getId());
	}	
}
