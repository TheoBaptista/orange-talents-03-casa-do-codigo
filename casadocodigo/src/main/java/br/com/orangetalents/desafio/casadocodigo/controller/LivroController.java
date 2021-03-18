package br.com.orangetalents.desafio.casadocodigo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.LivroDto;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.LivroForm;
import br.com.orangetalents.desafio.casadocodigo.domain.Autor;
import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;
import br.com.orangetalents.desafio.casadocodigo.domain.Livro;
import br.com.orangetalents.desafio.casadocodigo.repository.AutorRepository;
import br.com.orangetalents.desafio.casadocodigo.repository.CategoriaRepository;
import br.com.orangetalents.desafio.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	private final LivroRepository livroRepository;
	private final AutorRepository autorRepository;
	private final CategoriaRepository categoriaRepository;

	public LivroController(LivroRepository livroRepository, AutorRepository autorRepository,
			CategoriaRepository categoriaRepository) {
		this.livroRepository = livroRepository;
		this.autorRepository = autorRepository;
		this.categoriaRepository = categoriaRepository;
	}

	@PostMapping
	public ResponseEntity<LivroDto> cadastraLivro(@RequestBody LivroForm novoLivro) {

		System.out.println();
		
		Categoria Categoria = categoriaRepository.findByNome(novoLivro.getCategoriaDoLivro());
		Autor autor = autorRepository.findByNome(novoLivro.getAutorDoLivro());

		Livro livro = novoLivro.toLivro(autor, Categoria);
		livroRepository.save(livro);
		
		return ResponseEntity.ok().build();
	}

}
