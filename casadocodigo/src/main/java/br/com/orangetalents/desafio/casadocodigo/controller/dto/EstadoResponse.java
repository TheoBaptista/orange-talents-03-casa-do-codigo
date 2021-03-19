package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import br.com.orangetalents.desafio.casadocodigo.domain.Estado;

public class EstadoResponse {

	private String nome;
	private Long id;
	private String pais;
	private Long idPais;
	
	public EstadoResponse(String nome, Long id, String pais, Long idPais) {
		this.nome = nome;
		this.id = id;
		this.pais = pais;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public String getPais() {
		return pais;
	}

	public Long getIdPais() {
		return idPais;
	}
	
	public EstadoResponse build(Estado estado) {
		return new EstadoResponse(estado.getNome(), estado.getId(), estado.getPais().getNome(), estado.getPais().getId());
	}
	
}
