package br.com.orangetalents.desafio.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findOptionalByNome(String nome);
	
	Categoria findByNome(String nome);

	
}
