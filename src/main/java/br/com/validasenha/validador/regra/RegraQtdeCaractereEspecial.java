package br.com.validasenha.validador.regra;

/**
 * A classe RegraQtdeCaractereEspecial valida a quantidade mínima 
 * de caracteres especiais da senha.
 *
 * @author gustavoaragao
 */
public class RegraQtdeCaractereEspecial implements Regra {

	private static final String REGEX_CARACTERE_ESPECIAL = "[^ a-zA-Z0-9]";
	
	private int quantidadeMinima;

	/**
	 * Inicializa a quantidade mínima a ser valida.
	 *
	 * @param quantidadeMinima a quantidade mínima de caracteres especiais
	 */
	public RegraQtdeCaractereEspecial(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public boolean aplicar(String senha) {

		if (senha.length() - senha.replaceAll(REGEX_CARACTERE_ESPECIAL, "")
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
