package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;

public class CategoriaDto {

	private String nome;

	public CategoriaDto(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public static CategoriaDto build(Categoria categoria) {
		return new CategoriaDto(categoria.getNome());
	}
		
	
}
