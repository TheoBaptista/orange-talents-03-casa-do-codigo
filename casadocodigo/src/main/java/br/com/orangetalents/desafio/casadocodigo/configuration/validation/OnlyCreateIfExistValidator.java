package br.com.orangetalents.desafio.casadocodigo.configuration.validation;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.annotation.OnlyCreateIfExist;
import br.com.orangetalents.desafio.casadocodigo.repository.ValidatorRepository;

public class OnlyCreateIfExistValidator implements ConstraintValidator<OnlyCreateIfExist, Object> {

	private String nomeDoCampo;
	private Class<?> classeDeComparacao;	
	private EntityManager em;
			
	public OnlyCreateIfExistValidator(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void initialize(OnlyCreateIfExist constraintAnnotation) {
		classeDeComparacao = constraintAnnotation.classeDeComparacao();
		nomeDoCampo = constraintAnnotation.nomeDoCampo();
		
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		System.out.println(value);
		if(value == null) {
			return true;
		}
		return !ValidatorRepository.build(em).existEquals(nomeDoCampo, classeDeComparacao.getName() , value.toString().toUpperCase());
	}

}
