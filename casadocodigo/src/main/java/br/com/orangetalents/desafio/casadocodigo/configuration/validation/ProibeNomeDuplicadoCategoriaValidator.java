package br.com.orangetalents.desafio.casadocodigo.configuration.validation;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.CategoriaRequest;
import br.com.orangetalents.desafio.casadocodigo.domain.Categoria;
import br.com.orangetalents.desafio.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

	
	private CategoriaRepository repository;	
	
	public ProibeNomeDuplicadoCategoriaValidator(CategoriaRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return CategoriaRequest.class.isAssignableFrom(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) { 
			return;
		}
		
		CategoriaRequest categoriaRequest = (CategoriaRequest) target; 
		Optional<Categoria> possivelCategoria = repository.findOptionalByNome(categoriaRequest.getNome());
		
		if(possivelCategoria.isPresent()) {
			errors.rejectValue("nome", null,"A categoria "+categoriaRequest.getNome()+" já existe!");
		}
		
	}


}
