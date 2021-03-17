package br.com.orangetalents.desafio.casadocodigo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
	
	private @Id	@GeneratedValue(strategy = GenerationType.IDENTITY) Long id;	
	private @NotBlank String nome;

	@Deprecated
	public Categoria() {
	}
	
	public Categoria(@NotBlank String nome) {		
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}	
	
	
}
