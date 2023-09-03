package br.com.orangetalents.desafio.casadocodigo.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.orangetalents.desafio.casadocodigo.domain.Endereco;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.annotation.OnlyCreateIfExist;
import br.com.orangetalents.desafio.casadocodigo.configuration.validation.annotation.UniqueValueConstraint;
import br.com.orangetalents.desafio.casadocodigo.domain.Cliente;
import br.com.orangetalents.desafio.casadocodigo.domain.Estado;
import br.com.orangetalents.desafio.casadocodigo.domain.Pais;


public class ClienteRequest {

	private @NotBlank @Email @UniqueValueConstraint(classeDeComparacao = Cliente.class,nomeDoCampo = "email") String email;
	private @NotBlank String nome;
	private @NotBlank String sobrenome;
	private @NotBlank @UniqueValueConstraint(nomeDoCampo = "documento",classeDeComparacao = Cliente.class) String documento;
	private @NotBlank String endereco;
	private @NotBlank String complemento;
	private @NotBlank String cidade;
	private @NotBlank @OnlyCreateIfExist(classeDeComparacao = Pais.class, nomeDoCampo = "nome") String nomePais;
	private @OnlyCreateIfExist(classeDeComparacao = Estado.class, nomeDoCampo = "nome") String nomeEstado;
	private @NotBlank String telefone;
	private @NotBlank String cep;
	
	
	public ClienteRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String nomePais, String nomeEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.nomePais = nomePais;
		this.nomeEstado = nomeEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String getNomePais() {
		return nomePais;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}	
			
	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public boolean documentoValido() {
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		return cpfValidator.isValid(documento, null)
				|| cnpjValidator.isValid(documento, null);
	}
	
	public Cliente toCliente(Pais pais) {
		return new Cliente(this.email, this.nome,this.sobrenome,this.documento,this.telefone,new Endereco(this.endereco,this.complemento,this.cidade,this.cep,null,pais));
	}	
}
