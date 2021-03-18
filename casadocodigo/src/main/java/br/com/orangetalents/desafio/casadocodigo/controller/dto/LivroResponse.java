package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import br.com.orangetalents.desafio.casadocodigo.domain.Livro;

public class LivroResponse {

	private String titulo;
	private String resumo;
	private String isbn;
	
	
	public LivroResponse(String titulo, String resumo, String isbn) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.isbn = isbn;
	}
	
	public static LivroResponse build(Livro livro) {
		return new LivroResponse(livro.getTitulo(),livro.getResumo(), livro.getIsbn());
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getIsbn() {
		return isbn;
	}
	
	
	
}
