package br.com.orangetalents.desafio.casadocodigo.configuration.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import br.com.orangetalents.desafio.casadocodigo.controller.dto.ClienteRequest;
import br.com.orangetalents.desafio.casadocodigo.domain.Pais;

@Component
public class EstadoValidator implements org.springframework.validation.Validator {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		ClienteRequest clienteRequest = (ClienteRequest) target;
		

		String query = "SELECT p FROM Pais p WHERE p.nome=: pvalue";
		Pais pais = (Pais) em.createQuery(query).setParameter("pvalue", clienteRequest.getNomePais().toUpperCase())
				.getSingleResult();
		
		
		
		
		if(!pais.getEstados().isEmpty() && clienteRequest.getNomeEstado() == null) {
			
			errors.rejectValue("nomePais",null,"É necessário selecionar um estado para este país");
			
		}
		
		

		}	
	}

