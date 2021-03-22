package br.com.orangetalents.desafio.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orangetalents.desafio.casadocodigo.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {

}
