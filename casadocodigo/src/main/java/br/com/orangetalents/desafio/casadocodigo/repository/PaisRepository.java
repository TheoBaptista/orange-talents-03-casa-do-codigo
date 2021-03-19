package br.com.orangetalents.desafio.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orangetalents.desafio.casadocodigo.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

	Pais findByNome(String nome);

}
