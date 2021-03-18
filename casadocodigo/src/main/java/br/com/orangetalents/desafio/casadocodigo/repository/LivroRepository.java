package br.com.orangetalents.desafio.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orangetalents.desafio.casadocodigo.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro,Long> {

}
