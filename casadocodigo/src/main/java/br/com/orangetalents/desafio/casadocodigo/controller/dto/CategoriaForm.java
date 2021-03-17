
package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import javax.validation.constraints.NotBlank;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.UniqueValueContraint;
import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;

public class CategoriaForm {

	private @NotBlank @UniqueValueContraint(classeDeComparacao = Categoria.class,nomeDoCampo = "nome") String nome;
		
	public CategoriaForm(@NotBlank String nome) {
		this.nome = nome;
	}

	@Deprecated
	public CategoriaForm() {
	}
	
	public String getNome() {
		return nome;
	}
	public Categoria toCategoria() {		
		return new Categoria(this.nome);
	}
	
}
