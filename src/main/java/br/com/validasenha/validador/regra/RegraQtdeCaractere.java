package br.com.validasenha.validador.regra;

/**
 * A classe RegraQtdeCaractere valida a quantidade mínima 
 * de caracteres da senha.
 *
 * @author gustavoaragao
 */
public class RegraQtdeCaractere implements Regra {

	private int quantidadeMinima;

	/**
	 * Inicializa a quantidade mínima a ser valida.
	 *
	 * @param quantidadeMinima a quantidade mínima de caracteres
	 */
	public RegraQtdeCaractere(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean aplicar(String senha) {
		if (senha.length() < quantidadeMinima) {
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
