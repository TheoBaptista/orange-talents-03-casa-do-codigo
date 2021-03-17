package br.com.orangetalents.desafio.casadocodigo.configuration.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValueContraint, Object > {

	private String nomeDoCampo;
	private Class<?> classeDeComparacao;
	@PersistenceContext
	private EntityManager em;
		
	public UniqueValueValidator(EntityManager em) {
		this.em = em;
	}

	@Override
	public void initialize(UniqueValueContraint constraintAnnotation) {
		classeDeComparacao = constraintAnnotation.classeDeComparacao();
		nomeDoCampo = constraintAnnotation.nomeDoCampo();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		//String letraInicialDaclasse = classeDeComparacao.toString().substring(0, 1).toLowerCase(); não consegui desse jeito apenas colocando o 1
		String query = "SELECT 1 FROM "+classeDeComparacao.getName()+" WHERE "+nomeDoCampo+" =:pvalue";  
		List<?> resultList = em.createQuery(query).setParameter("pvalue", value).getResultList();
		// ver se posso encapsular essa parte!!!		
		return resultList.isEmpty();
	}

	
	

}
