package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import javax.validation.constraints.NotBlank;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.annotation.OnlyCreateIfExist;
import br.com.orangetalents.desafio.casadocodigo.configuration.validation.annotation.UniqueValueConstraint;
import br.com.orangetalents.desafio.casadocodigo.domain.Estado;
import br.com.orangetalents.desafio.casadocodigo.domain.Pais;

public class EstadoRequest {

	private @NotBlank @UniqueValueConstraint(nomeDoCampo = "nome", classeDeComparacao =  Estado.class) String nome;
	private @NotBlank @OnlyCreateIfExist(nomeDoCampo = "nome", classeDeComparacao = Pais.class) String nomePais;
	
	public EstadoRequest(@NotBlank String nome, @NotBlank String nomePais) {
		this.nome = nome;
		this.nomePais = nomePais;
	}

	public String getNome() {
		return nome;
	}	
			
	public String getNomePais() {
		return nomePais;
	}

	public Estado toEstado(Pais pais) {
		return new Estado(this.nome,pais);
	}
	
}
