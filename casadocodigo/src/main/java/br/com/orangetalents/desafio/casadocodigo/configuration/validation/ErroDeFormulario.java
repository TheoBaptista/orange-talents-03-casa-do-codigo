package br.com.orangetalents.desafio.casadocodigo.configuration.validation;

public class ErroDeFormulario {

	
	private String campo;
	private String mensagem;
	
	
	
	public ErroDeFormulario(String field, String mensagem) {
		this.campo = field;
		this.mensagem = mensagem;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
