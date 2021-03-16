package br.com.orangetalents.desafio.casadocodigo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@PostMapping
	public ResponseEntity<?> cadastraCategoria(){
		System.out.println("olá");
		return ResponseEntity.ok().build();
				}	
}
