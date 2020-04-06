package br.com.validasenha.validador;

import java.util.List;

import org.springframework.util.StringUtils;

import br.com.validasenha.validador.regra.Regra;

/**
 * A classe ExecutorValidadorSenha executa as regras determinadas nos
 * validadores de senha.
 *
 * @author gustavoaragao
 */
public final class ExecutorValidadorSenha {

	private List<Regra> listaRegras;
	
	/**
	 * Inicializa a lista de regras.
	 *
	 * @param listaRegras the lista regras
	 */
	public ExecutorValidadorSenha(List<Regra> listaRegras) {
		this.listaRegras = listaRegras;
	}
	
	/**
	 * Métodos responsável por validar a lista de regras do validador chamador.
	 *
	 * @param senha a senha a ser validada
	 * @return true se validado com sucesso
	 */
	public boolean validar(String senha) {

		if (StringUtils.isEmpty(senha) || listaRegras.isEmpty()) {
			return false;
		}

		boolean aprovado = true;

		for (Regra regra : listaRegras) {
			if (!regra.aplicar(senha)) {
				aprovado = false;
				break;
			}
		}

		return aprovado;
	}

	/**
	 * Retorna a lista regras.
	 *
	 * @return {@code List} a lista de regras
	 */
	public List<Regra> getListaRegras() {
		return listaRegras;
	}

	/**
	 * Seta a lista regras a ser validada.
	 *
	 * @param listaRegras a lista de regras
	 */
	public void setListaRegras(List<Regra> listaRegras) {
		this.listaRegras = listaRegras;
	}
}
