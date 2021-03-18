package br.com.orangetalents.desafio.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orangetalents.desafio.casadocodigo.domain.Autor;

public interface AutorRepository extends JpaRepository <Autor,Long> {

	Optional<Autor> findByEmail(String email);

	Autor findByNome(String nome);
	
}
