package br.com.orangetalents.desafio.casadocodigo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

	private @Id @GeneratedValue Long id;
	private @NotBlank String nome;	
	private @ManyToOne @NotBlank Pais pais;
	
	public Estado(Long id, String nome, Pais pais) {
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}
	
	public Boolean jaPertenceAoPais(Pais pais) {
		 return this.pais.equals(pais);
	}
	
	@Deprecated
	public Estado() {
	}

	@Override
	public String toString() {
		return "Estado [nome=" + nome + "]";
	}
	
	

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
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
		Estado other = (Estado) obj;
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
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		return true;
	}	
}
