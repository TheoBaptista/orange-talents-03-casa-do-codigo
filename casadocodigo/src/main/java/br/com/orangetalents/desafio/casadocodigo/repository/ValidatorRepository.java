package br.com.orangetalents.desafio.casadocodigo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ValidatorRepository {

	@PersistenceContext // necessario para ser injetado na classe
	private final EntityManager em;

	public ValidatorRepository(EntityManager em) {
		this.em = em;
	}
	
	public Boolean existEquals(String field, String clazzName, String value) {		
		String query = "SELECT 1 FROM "+clazzName+" WHERE "+field+" =:pvalue";  
		List<?> resultList = em.createQuery(query).setParameter("pvalue", value).getResultList();		
		return resultList.isEmpty();
	}
	
	public static ValidatorRepository build(EntityManager em){
		return new ValidatorRepository(em);
	}
	
	
}
