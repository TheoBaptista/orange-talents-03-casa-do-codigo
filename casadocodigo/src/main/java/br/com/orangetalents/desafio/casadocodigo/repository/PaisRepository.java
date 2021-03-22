package br.com.orangetalents.desafio.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orangetalents.desafio.casadocodigo.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

	Pais findByNome(String nome);

}
