package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import br.com.orangetalents.desafio.casadocodigo.domain.Autor;

public class AutorDto {

	private String nome;
	private String email;
	private String descricao;
	
	public AutorDto(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public static AutorDto buildAutor(Autor novoAutor) {
		return new AutorDto(novoAutor.getNome(),novoAutor.getEmail(),novoAutor.getDescricao());
	}
	
	
	
	
}
