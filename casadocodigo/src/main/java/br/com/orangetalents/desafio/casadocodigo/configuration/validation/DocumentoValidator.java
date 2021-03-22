package br.com.orangetalents.desafio.casadocodigo.configuration.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.ClienteRequest;

@Component
public class DocumentoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		 ClienteRequest requisicao = (ClienteRequest) target;
		 
		 if(!requisicao.documentoValido()) {
			errors.rejectValue("documento", null, "Precisa ser um cpf ou cnpj válido"); 
		 }		
	}

}
