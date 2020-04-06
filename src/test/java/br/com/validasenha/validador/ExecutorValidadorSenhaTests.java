package br.com.validasenha.validador;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.validasenha.validador.regra.Regra;
import br.com.validasenha.validador.regra.RegraQtdeCaractere;

/**
 * A classe ExecutorValidadorSenhaTests testa se a lista de regras está executando
 * como o esperado e se a chamada das regras está funcionando.
 *
 * @author gustavoaragao
 */
public class ExecutorValidadorSenhaTests {
	
	/** O executor validador de senha. */
	private ExecutorValidadorSenha executorValidadorSenha; 
	
	/**
	 * Teste lista regras vazio.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeListaRegrasVazio() throws Exception {
		
		List<Regra> listaRegras = new ArrayList<Regra>();
		
		executorValidadorSenha = new ExecutorValidadorSenha(listaRegras);

		Assertions.assertFalse(executorValidadorSenha.validar(""));
	}	
		
	/**
	 * Teste senha nula ou em branco.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeSenhaNulaOuEmBranco() throws Exception {
		
		List<Regra> listaRegras = new ArrayList<Regra>();
		listaRegras.add(new RegraQtdeCaractere(5));
		
		executorValidadorSenha = new ExecutorValidadorSenha(listaRegras);

		Assertions.assertFalse(executorValidadorSenha.validar(""));
	}	

	/**
	 * Teste regra executada dentro do criterio.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeRegraExecutadaDentroDoCriterio() throws Exception {
		
		List<Regra> listaRegras = new ArrayList<Regra>();
		listaRegras.add(new RegraQtdeCaractere(5));
		
		executorValidadorSenha = new ExecutorValidadorSenha(listaRegras);

		Assertions.assertTrue(executorValidadorSenha.validar("12345"));
	}
	
	/**
	 * Teste regra executada fora do criterio.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeRegraExecutadaForaDoCriterio() throws Exception {
		
		List<Regra> listaRegras = new ArrayList<Regra>();
		listaRegras.add(new RegraQtdeCaractere(5));
		
		executorValidadorSenha = new ExecutorValidadorSenha(listaRegras);

		Assertions.assertFalse(executorValidadorSenha.validar("1"));
	}
}
