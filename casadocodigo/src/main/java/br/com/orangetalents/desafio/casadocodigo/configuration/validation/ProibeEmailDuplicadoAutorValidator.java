package br.com.orangetalents.desafio.casadocodigo.configuration.validation;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.AutorRequest;
import br.com.orangetalents.desafio.casadocodigo.domain.Autor;
import br.com.orangetalents.desafio.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	
	private AutorRepository repository;	
	
	public ProibeEmailDuplicadoAutorValidator(AutorRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// especificar o tipo de parametro que queremos aplicar essa validacao
		return AutorRequest.class.isAssignableFrom(clazz); // essa classe passada pode ser igual ou filha
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) { // caso haja algum erro de validacao do spring será retornado. Validacoes padroes antes da implementacao propria
			return;
		}
		
		AutorRequest autorRequest = (AutorRequest) target; // target é o formulario em questao que sera validado
		Optional<Autor> possivelAutor = repository.findByEmail(autorRequest.getEmail());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email", null/* aqui eh para definir errorCode com mensagens localizadas etc*/,"O e-mail "+autorRequest.getEmail()+" já esta sendo usado! " /*Mensagem padrao*/);
		}
		
	}


}
