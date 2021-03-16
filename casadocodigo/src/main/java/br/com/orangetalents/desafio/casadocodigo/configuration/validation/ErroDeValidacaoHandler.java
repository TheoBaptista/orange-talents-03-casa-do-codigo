package br.com.orangetalents.desafio.casadocodigo.configuration.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
//	 a classe que vai tratar os erros de validação.
//	O Spring tem uma solução para esse tipo de cenário. A solução é criar um interceptador. Toda vez que acontecer uma exception, em qualquer método,
//	o Spring automaticamente vai chamar esse interceptador,
//	onde fazemos o tratamento apropriado. Esse interceptador é chamado de controller advice.
	
	@Autowired
	private MessageSource messageSource;	

	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormulario> handle(MethodArgumentNotValidException exception){
		
		List<ErroDeFormulario> erroDeFormulario = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach( e -> {
				String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
				ErroDeFormulario erro = new ErroDeFormulario(e.getField(), mensagem);
				erroDeFormulario.add(erro);
		});
		return erroDeFormulario;
	}
}
