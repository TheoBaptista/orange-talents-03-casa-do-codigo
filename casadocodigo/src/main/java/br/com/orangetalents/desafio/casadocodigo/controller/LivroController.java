package br.com.orangetalents.desafio.casadocodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.LivroResponse;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.LivroRequest;
import br.com.orangetalents.desafio.casadocodigo.domain.Autor;
import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;
import br.com.orangetalents.desafio.casadocodigo.domain.Livro;
import br.com.orangetalents.desafio.casadocodigo.repository.AutorRepository;
import br.com.orangetalents.desafio.casadocodigo.repository.CategoriaRepository;
import br.com.orangetalents.desafio.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("api/livros")
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
	public ResponseEntity<LivroResponse> cadastraLivro(@Valid @RequestBody LivroRequest novoLivro) {

	
		Categoria categoria = categoriaRepository.findByNome(novoLivro.getNomeCategoria().toUpperCase());
		Autor autor = autorRepository.findByNome(novoLivro.getNomeAutor().toUpperCase());

	
		Livro livro = novoLivro.toLivro(autor, categoria);
		livroRepository.save(livro);
		
		return ResponseEntity.ok(LivroResponse.build(livro));
	}
	
	@GetMapping
	public List<LivroResponse> listaLivros(){
		return LivroResponse.build(livroRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> detalheLivro(@PathVariable("id") Long id){
		
		System.out.println(id);
		
		return ResponseEntity.ok().build();
	}

}
