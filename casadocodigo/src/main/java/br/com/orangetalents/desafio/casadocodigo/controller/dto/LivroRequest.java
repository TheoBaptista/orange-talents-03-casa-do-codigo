package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.OnlyCreateIfExist;
import br.com.orangetalents.desafio.casadocodigo.configuration.validation.UniqueValueConstraint;
import br.com.orangetalents.desafio.casadocodigo.domain.Autor;
import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;
import br.com.orangetalents.desafio.casadocodigo.domain.Livro;

public class LivroRequest {

	private @NotBlank @UniqueValueConstraint(nomeDoCampo = "titulo", classeDeComparacao = Livro.class) String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private String sumario;
	private @NotNull @Min(value = 20) BigDecimal preco;
	private @NotNull @Min(value = 100) Integer numeroDePaginas;
	private @NotBlank @UniqueValueConstraint(nomeDoCampo = "isbn", classeDeComparacao = Livro.class) String isbn;	
	private @Future @NotNull @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING) LocalDate dataDePublicacao;
	private @NotBlank @OnlyCreateIfExist(classeDeComparacao = Categoria.class,nomeDoCampo = "nome") String nomeCategoria; 
	private @NotBlank @OnlyCreateIfExist(classeDeComparacao = Autor.class,nomeDoCampo = "nome") String nomeAutor;

	@Deprecated
	public LivroRequest() {
	}
	
	public LivroRequest(@NotBlank String titulo, @NotBlank @Max(500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroDePaginas, @NotBlank String isbn, @NotBlank String nomeCategoria,
			@NotBlank String nomeAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;		
		this.nomeCategoria = nomeCategoria;// Se tirar não vai achar
		this.nomeAutor = nomeAutor; // Se tirar não vai achar 
	}
	
	

	public void setDataDePublicacao(LocalDate dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public @NotBlank String getNomeCategoria() {
		return nomeCategoria.toUpperCase();
	}

	public @NotBlank String getNomeAutor() {
		return nomeAutor.toUpperCase();
	}	

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}

	public Livro toLivro(Autor autor, Categoria categoria) {
		return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataDePublicacao, categoria, autor);
	}

}
