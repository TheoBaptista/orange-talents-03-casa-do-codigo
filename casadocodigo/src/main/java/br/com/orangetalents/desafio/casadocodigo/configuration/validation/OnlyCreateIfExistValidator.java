package br.com.orangetalents.desafio.casadocodigo.configuration.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.annotation.OnlyCreateIfExist;

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
		if(value == null) {
			return true;
		}
		
		String query = "SELECT 1 FROM "+ classeDeComparacao.getName() +" WHERE "+nomeDoCampo +" =:pvalue";  
		List<?> resultList = em.createQuery(query).setParameter("pvalue", value.toString().toUpperCase()).getResultList();		
		return !resultList.isEmpty();	
		
	}

}
