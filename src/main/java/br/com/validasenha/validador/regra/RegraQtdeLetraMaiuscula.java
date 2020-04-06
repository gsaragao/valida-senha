package br.com.validasenha.validador.regra;

/**
 * A classe RegraQtdeLetraMaiuscula valida a quantidade mínima 
 * de letras maiúsculas da senha.
 *
 * @author gustavoaragao
 */
public class RegraQtdeLetraMaiuscula implements Regra {

	private static final String REGEX_LETRAS_MAIUSCULAS = "[A-Z]";
	
	private int quantidadeMinima;

	/**
	 * Inicializa a quantidade mínima a ser valida.
	 *
	 * @param quantidadeMinima a quantidade mínima de letras maiúsculas
	 */
	public RegraQtdeLetraMaiuscula(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public boolean aplicar(String senha) {

		if (senha.length() - senha.replaceAll(REGEX_LETRAS_MAIUSCULAS, "")
				.length() < quantidadeMinima) {
			return false;
		}
		return true;
	}
	
	/**
	 * Retorna o quantidade minima.
	 *
	 * @return int - a quantidade minima
	 */
	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}
}
