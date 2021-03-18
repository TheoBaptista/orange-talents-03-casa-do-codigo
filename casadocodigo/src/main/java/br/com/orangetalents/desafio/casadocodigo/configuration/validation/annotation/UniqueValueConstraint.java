package br.com.orangetalents.desafio.casadocodigo.configuration.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.orangetalents.desafio.casadocodigo.configuration.validation.UniqueValueValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=UniqueValueValidator.class)
public @interface UniqueValueConstraint {

	Class<?> classeDeComparacao();
	
	String nomeDoCampo();	
	
	//tem que colocar a mensagem parameter caso contrario tomarei exception
	String message() default "Já existe o valor parecido no nosso sistema"; // colocoquei generica mas tenho que mudar para uma melhor
	
	// tambem tem que ter o groups paramater caso contrario tomarei outra exception
	Class<?>[] groups() default { };
	
	// mesma coisa que as anteriores
	Class<? extends Payload>[] payload() default { };
	
}
