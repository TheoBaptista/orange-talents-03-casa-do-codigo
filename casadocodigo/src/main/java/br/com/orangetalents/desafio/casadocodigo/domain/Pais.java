package br.com.orangetalents.desafio.casadocodigo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id; 
	private @NotBlank String nome;
	private @OneToMany(mappedBy = "pais", fetch = FetchType.EAGER) List<Estado> estados = new ArrayList<>();
	
	
		
	public Pais(@NotBlank String nome) {
		this.nome = nome.toUpperCase();
		
	}

	@Deprecated
	public Pais() {
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}	

	public List<Estado> getEstados() {
		return estados;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Pais other = (Pais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
	
	
}
