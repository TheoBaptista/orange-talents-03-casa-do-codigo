package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import br.com.orangetalents.desafio.casadocodigo.domain.Autor;

public class AutorResponse {

	private String nome;
	private String email;
	private String descricao;
	
	public AutorResponse(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
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

	public static AutorResponse buildAutor(Autor novoAutor) {
		return new AutorResponse(novoAutor);
	}
	
	
	
	
}
