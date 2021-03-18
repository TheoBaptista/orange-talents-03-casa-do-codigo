package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;

public class CategoriaResponse {

	private String nome;

	public CategoriaResponse(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public static CategoriaResponse build(Categoria categoria) {
		return new CategoriaResponse(categoria.getNome());
	}
		
	
}
