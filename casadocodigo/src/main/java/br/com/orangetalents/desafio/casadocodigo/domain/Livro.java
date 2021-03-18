package br.com.orangetalents.desafio.casadocodigo.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Livro {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private @NotBlank String titulo;
	private @NotBlank @Max(value = 500) String resumo;
	private String sumario;
	private @NotBlank @Min(value = 20) BigDecimal preco;
	private @NotBlank @Min(value = 100) Integer numeroDePaginas;
	private @NotBlank String isbn;
	private @NotBlank @Future LocalDate dataDePublicacao;
	private @NotBlank @ManyToOne Categoria categoriaDoLivro;
	private @NotBlank @ManyToOne Autor autorDoLivro;

	@Deprecated
	public Livro() {
	}
	
	public Livro(@NotBlank String titulo, @NotBlank @Max(500) String resumo, String sumario,
			@NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) Integer numeroDePaginas, @NotBlank String isbn,
			@NotBlank @Future @NotBlank @Future LocalDate dataDePublicacao2, @NotBlank Categoria categoriaDoLivro,
			@NotBlank Autor autorDoLivro) {
		this.titulo = titulo.toUpperCase();
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao2;
		this.categoriaDoLivro = categoriaDoLivro;
		this.autorDoLivro = autorDoLivro;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco=" + preco
				+ ", isbn=" + isbn + ", categoriaDoLivro=" + categoriaDoLivro + ", autorDoLivro=" + autorDoLivro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
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
