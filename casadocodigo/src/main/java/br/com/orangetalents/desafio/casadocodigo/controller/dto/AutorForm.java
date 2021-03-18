package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.UniqueValueConstraint;
import br.com.orangetalents.desafio.casadocodigo.domain.Autor;


public class AutorForm {

	private @NotBlank String nome;	
	private @NotBlank @Email @UniqueValueConstraint(classeDeComparacao = Autor.class,nomeDoCampo = "email") String email;	
	private @NotBlank @Size(max = 400) String descricao;	

	@Deprecated
	public AutorForm() {
	}
	
	public AutorForm(@NotBlank String nome,@Email @NotBlank String email,@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;		
	}
	
	public String getEmail() {
		return email;
	}	

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor toAutor() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
}
