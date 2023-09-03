package br.com.orangetalents.desafio.casadocodigo.domain;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
public class Autor {

	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private @NotBlank  String nome;
	private @Email @NotBlank String email;
	private @NotBlank @Size(max = 400) String descricao;
	private @Column(name = "data_do_registro") LocalDateTime dataDoRegistro = LocalDateTime.now() ;

	public Autor(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
		this.nome = nome.toUpperCase();
		this.email = email.toUpperCase();
		this.descricao = descricao;		
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}	

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", descricao=" + descricao + ", dataDoRegistro=" + dataDoRegistro + "]";
	}



}
