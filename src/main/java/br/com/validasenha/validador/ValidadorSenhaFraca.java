package br.com.validasenha.validador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.validasenha.validador.regra.Regra;
import br.com.validasenha.validador.regra.RegraQtdeCaractere;
import br.com.validasenha.validador.regra.RegraQtdeDigito;
import br.com.validasenha.validador.regra.RegraQtdeLetraMinuscula;

/**
 * A classe ValidadorSenhaFraca é responsável por definir quais regras
 * serão utilizadas para validar uma senha como fraca e chamar o executor 
 * de validação.
 *
 * @author gustavoaragao
 */
@Component
@Qualifier("fraca")
public final class ValidadorSenhaFraca implements ValidadorSenha {
	
	/** Constante referente a quantidade mínima de caracteres de uma senha */
	private static final int REGRA_QUANTIDADE_MINIMA = 4;
	
	/** Constante referente a quantidade mínima de dígitos de uma senha */
	private static final int REGRA_QUANTIDADE_DIGITO = 1;
	
	/** Constante referente a quantidade mínima de letras minúscula de uma senha */
	private static final int REGRA_QUANTIDADE_LETRA_MINUSCULA = 1;
	
	private ExecutorValidadorSenha executorValidadorSenha;
	
	/**
	 * Define as regras que serão utilizadas para validar uma senha fraca.
	 */
	public ValidadorSenhaFraca() {
		List<Regra> listaRegras = new ArrayList<Regra>();
		listaRegras.add(new RegraQtdeCaractere(REGRA_QUANTIDADE_MINIMA));
		listaRegras.add(new RegraQtdeDigito(REGRA_QUANTIDADE_DIGITO));
		listaRegras.add(new RegraQtdeLetraMinuscula(REGRA_QUANTIDADE_LETRA_MINUSCULA));
		executorValidadorSenha = new ExecutorValidadorSenha(listaRegras);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validar(String senha) {
		return executorValidadorSenha.validar(senha);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public List<Regra> getListaRegras() {
		return executorValidadorSenha.getListaRegras();
	}

}
