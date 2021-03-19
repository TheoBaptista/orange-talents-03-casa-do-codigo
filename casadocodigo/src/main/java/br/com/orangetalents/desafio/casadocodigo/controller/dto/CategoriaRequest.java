
package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.annotation.UniqueValueConstraint;
import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;

public class CategoriaRequest {

	private @NotBlank @UniqueValueConstraint(classeDeComparacao = Categoria.class, nomeDoCampo = "nome") String nome;

	@JsonCreator
	public CategoriaRequest(@NotBlank @JsonProperty("nome") String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Categoria toCategoria() {
		return new Categoria(this.nome);
	}

}
