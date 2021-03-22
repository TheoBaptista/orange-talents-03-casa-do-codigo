package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import br.com.orangetalents.desafio.casadocodigo.domain.Cliente;

public class ClienteResponse {

	private String nome;
	private String email; 
	private String documento;
	private String endereco;
	
	
	
	public ClienteResponse(String nome, String email, String documento, String endereco) {
		this.nome = nome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
	}



	public String getNome() {
		return nome;
	}



	public String getEmail() {
		return email;
	}



	public String getDocumento() {
		return documento;
	}



	public String getEndereco() {
		return endereco;
	}
	
	public static ClienteResponse build(Cliente cliente) {
		return new ClienteResponse(cliente.getNome(), cliente.getEmail(), cliente.getDocumento(), cliente.getEndereco());
	}
 
	
	
	
}
