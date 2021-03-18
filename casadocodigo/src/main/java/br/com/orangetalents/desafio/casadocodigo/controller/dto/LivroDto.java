package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import br.com.orangetalents.desafio.casadocodigo.domain.Livro;

public class LivroDto {

	private String titulo;
	private String resumo;
	private String isbn;
	
	
	public LivroDto(String titulo, String resumo, String isbn) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.isbn = isbn;
	}
	
	public static LivroDto build(Livro livro) {
		return new LivroDto(livro.getTitulo(),livro.getResumo(), livro.getIsbn());
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
