package br.com.validasenha.validador.regra;

/**
 * A classe RegraQtdeLetraMinuscula valida a quantidade mínima 
 * de letras minúsculas da senha.
 *
 * @author gustavoaragao
 */
public class RegraQtdeLetraMinuscula implements Regra {

	private static final String REGEX_LETRAS_MINUSCULA = "[a-z]";
	
	private int quantidadeMinima;

	/**
	 * Inicializa a quantidade mínima a ser valida.
	 *
	 * @param quantidadeMinima a quantidade mínima de letras minúsculas
	 */
	public RegraQtdeLetraMinuscula(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public boolean aplicar(String senha) {

		if (senha.length() - senha.replaceAll(REGEX_LETRAS_MINUSCULA, "")
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
