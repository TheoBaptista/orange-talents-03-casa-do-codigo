package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import javax.validation.constraints.NotNull;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.annotation.UniqueValueConstraint;
import br.com.orangetalents.desafio.casadocodigo.domain.Pais;

public class PaisRequest {

	private @NotNull @UniqueValueConstraint(nomeDoCampo = "nome",classeDeComparacao = Pais.class) String nome;

	public PaisRequest(@NotNull String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}	
	
}
