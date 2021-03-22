package br.com.orangetalents.desafio.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orangetalents.desafio.casadocodigo.domain.Autor;

@Repository
public interface AutorRepository extends JpaRepository <Autor,Long> {

	Optional<Autor> findByEmail(String email);

	Autor findByNome(String nome);
	
}
