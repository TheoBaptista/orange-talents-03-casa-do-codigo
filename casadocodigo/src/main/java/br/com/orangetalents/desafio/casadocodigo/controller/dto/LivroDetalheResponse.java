package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import java.math.BigDecimal;

import br.com.orangetalents.desafio.casadocodigo.domain.Livro;

public class LivroDetalheResponse {

	private String titulo;
	private String resumo;
	private BigDecimal preco;
	private String sumario;
	private String nomeAutor;
	private String descricaoAutor;
	private Integer numeroDePaginas;
	private String isbn;
	
	public LivroDetalheResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.preco = livro.getPreco();
		this.sumario = livro.getSumario();
		this.nomeAutor = livro.getAutorDoLivro().getNome();
		this.descricaoAutor = livro.getAutorDoLivro().getDescricao();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.isbn =livro.getIsbn();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getSumario() {
		return sumario;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public static LivroDetalheResponse build(Livro livro) {
		return new LivroDetalheResponse(livro);
	}
	
	
}
