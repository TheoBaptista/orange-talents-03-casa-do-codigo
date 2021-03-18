package br.com.orangetalents.desafio.casadocodigo.configuration.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= OnlyCreateIfExistValidator.class)
public @interface OnlyCreateIfExist {

	Class<?> classeDeComparacao();
	
	String nomeDoCampo();	
	
	
	String message() default "Não existe esse valor no sistema"; 
	
	
	Class<?>[] groups() default { };
	
	
	Class<? extends Payload>[] payload() default { };
	
}
