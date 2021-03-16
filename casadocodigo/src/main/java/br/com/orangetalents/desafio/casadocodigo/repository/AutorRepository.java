package br.com.orangetalents.desafio.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orangetalents.desafio.casadocodigo.domain.Autor;

public interface AutorRepository extends JpaRepository <Autor,Long> {

}
