package br.com.validasenha.validador.regra;

/**
 * A classe RegraQtdeDigito valida a quantidade mínima 
 * de dígitos da senha.
 *
 * @author gustavoaragao
 */
public class RegraQtdeDigito implements Regra {

	private static final String REGEX_DIGITOS = "\\d";
	
	private int quantidadeMinima;

	/**
	 * Inicializa a quantidade mínima a ser valida.
	 *
	 * @param quantidadeMinima a quantidade mínima de dígitos
	 */
	public RegraQtdeDigito(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public boolean aplicar(String senha) {

		if (senha.length() - senha.replaceAll(REGEX_DIGITOS, "")
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
