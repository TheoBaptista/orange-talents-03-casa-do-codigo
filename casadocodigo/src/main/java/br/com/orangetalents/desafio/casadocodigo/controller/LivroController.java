package br.com.orangetalents.desafio.casadocodigo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.LivroDetalheResponse;
import br.com.orangetalents.desafio.casadocodigo.controller.dto.LivroResponse;
import br.com.orangetalents.desafio.casadocodigo.domain.Livro;
import br.com.orangetalents.desafio.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("api/livros")
public class LivroController {

	private final LivroRepository livroRepository;

	
	
	public LivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@GetMapping
	public List<LivroResponse> listaLivros(){
		return LivroResponse.build(livroRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroDetalheResponse> detalheLivro(@PathVariable("id") Long id){
		
		Optional<Livro> optionalLivro = livroRepository.findById(id);
		
		if (optionalLivro.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(LivroDetalheResponse.build(optionalLivro.get()));
	}

}
