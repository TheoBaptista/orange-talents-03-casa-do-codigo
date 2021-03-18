package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.UniqueValueConstraint;
import br.com.orangetalents.desafio.casadocodigo.domain.Autor;
import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;
import br.com.orangetalents.desafio.casadocodigo.domain.Livro;

public class LivroForm {

	private @NotBlank @UniqueValueConstraint(nomeDoCampo = "titulo", classeDeComparacao = Livro.class) String titulo;
	private @NotBlank @Max(value = 500) String resumo;
	private String sumario;
	private @NotBlank @Min(value = 20) BigDecimal preco;
	private @NotBlank @Min(value = 100) Integer numeroDePaginas;
	private @NotBlank @UniqueValueConstraint(nomeDoCampo = "isbn", classeDeComparacao = Livro.class) String isbn;
	private @NotBlank @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING) LocalDate dataDePublicacao;
	private @NotBlank String categoriaDoLivro; // criar validacao
	private @NotBlank String autorDoLivro; // criar validacao

	@Deprecated
	public LivroForm() {
	}
	
	public LivroForm(@NotBlank String titulo, @NotBlank @Max(500) String resumo, String sumario,
			@NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) Integer numeroDePaginas, @NotBlank String isbn, @NotBlank String categoriaDoLivro,
			@NotBlank String autorDoLivro) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;		
		this.categoriaDoLivro = categoriaDoLivro;
		this.autorDoLivro = autorDoLivro;
	}
	
	

	public void setDataDePublicacao(LocalDate dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public String getCategoriaDoLivro() {
		return categoriaDoLivro;
	}

	public String getAutorDoLivro() {
		return autorDoLivro;
	}

	public Livro toLivro(Autor autor, Categoria categoria) {
		return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataDePublicacao, categoria, autor);
	}

}
