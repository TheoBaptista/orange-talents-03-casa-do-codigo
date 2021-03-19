package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.orangetalents.desafio.casadocodigo.domain.Livro;

public class LivroResponse {

	private Long id;
	private String titulo;
	private String resumo;
	private String isbn;

	public LivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.isbn = livro.getIsbn();
		this.id = livro.getId();
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

	public Long getId() {
		return id;
	}

	public static List<LivroResponse> build(List<Livro> livros) {
		return livros.stream().map(livro -> new LivroResponse(livro))
				.collect(Collectors.toList());
	}

	public static LivroResponse build(Livro livro) {
		return new LivroResponse(livro);
	}

}
