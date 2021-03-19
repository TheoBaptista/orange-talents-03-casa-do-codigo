package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.annotation.UniqueValueConstraint;
import br.com.orangetalents.desafio.casadocodigo.domain.Pais;

public class PaisRequest {

	private @NotBlank @UniqueValueConstraint(nomeDoCampo = "nome",classeDeComparacao = Pais.class) String nome;

	@JsonCreator
	public PaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}	
	
	public Pais toPais() {
		return new Pais(nome);
	}
	
}
