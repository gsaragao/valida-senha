package br.com.validasenha.dto;

/**
 * A classe Param.
 */
public class Param {
	
	private String senha;
	
	/**
	 * Construtor com parametro senha
	 * @param senha a nova senha
	 */
	public Param(String senha) {
		this.senha = senha;
	} 
	
	/**
	 * Construtor default 
	 */
	public Param() {
	}

	/**
	 * Retorna a senha.
	 *
	 * @return String - a senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Seta a senha.
	 *
	 * @param senha a senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
