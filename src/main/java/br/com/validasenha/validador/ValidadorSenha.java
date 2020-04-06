package br.com.validasenha.validador;

import java.util.List;

import br.com.validasenha.validador.regra.Regra;

/**
 * A ValidadorSenha é a interface dos validadores de senha.
 *
 * Cada classe que implentar esta interface, deverá definir 
 * um {@code Qualifier} distinto para que possa ser identificado
 * unicamente no Controller.
 *
 * @author gustavoaragao
 */
public interface ValidadorSenha {

	/**
	 * Método padrão dos validadores de senha.
	 *
	 * @param senha - a senha a validada
	 * @return true, se validado com sucesso
	 */
	boolean validar(String senha);
	
	/**
	 * Retorna a lista de regras.
	 *
	 * @return List - lista de regras 
	 */
	List<Regra> getListaRegras();
}
