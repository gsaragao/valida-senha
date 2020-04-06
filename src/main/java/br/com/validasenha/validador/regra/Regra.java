package br.com.validasenha.validador.regra;

/**
 * A Regra é a interface das regras de validação de uma senha.
 *
 * @author gustavoaragao
 */
public interface Regra {

	/**
	 * Método responsável por aplicar a regra de validação 
	 * específica da classe.
	 *
	 * @param senha a senha a ser validada
	 * @return true, se validado com sucesso
	 */
	boolean aplicar(String senha);
}
