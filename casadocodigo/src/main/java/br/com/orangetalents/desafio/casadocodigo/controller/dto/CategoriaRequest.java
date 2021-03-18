
package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import javax.validation.constraints.NotBlank;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.UniqueValueConstraint;
import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;

public class CategoriaRequest {

	private @NotBlank @UniqueValueConstraint(classeDeComparacao = Categoria.class,nomeDoCampo = "nome") String nome;
		
	public CategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	@Deprecated
	public CategoriaRequest() {
	}
	
	public String getNome() {
		return nome;
	}
	public Categoria toCategoria() {		
		return new Categoria(this.nome);
	}
	
}
