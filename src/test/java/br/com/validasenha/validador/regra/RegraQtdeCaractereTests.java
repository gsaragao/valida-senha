package br.com.validasenha.validador.regra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A classe RegraQtdeCaractereTests verifica se a regra de quantidade de
 * caracteres está sendo aplicada corretamente.
 *
 * @author gustavoaragao
 */
public class RegraQtdeCaractereTests {

	/**
	 * Teste quantidade minima no parametro.
	 */
	@Test
	public void testeQuantidadeMinimaNoParametro() {
		Assertions.assertEquals(1, new RegraQtdeCaractere(1).getQuantidadeMinima());
		Assertions.assertNotEquals(2, new RegraQtdeCaractere(3).getQuantidadeMinima());
		Assertions.assertEquals(20, new RegraQtdeCaractere(20).getQuantidadeMinima());
	}

	/**
	 * Teste aplicar regra quantidade de caractere.
	 */
	@Test
	public void testeAplicarRegraQuantidadeCaractere() {
		Assertions.assertTrue(new RegraQtdeCaractere(1).aplicar("1"));
		Assertions.assertTrue(new RegraQtdeCaractere(2).aplicar("#$"));
		Assertions.assertTrue(new RegraQtdeCaractere(3).aplicar("123"));
		Assertions.assertTrue(new RegraQtdeCaractere(4).aplicar("mAd&"));
		Assertions.assertTrue(new RegraQtdeCaractere(1).aplicar("mAd&+({aaaa"));

		Assertions.assertFalse(new RegraQtdeCaractere(1).aplicar(""));
		Assertions.assertFalse(new RegraQtdeCaractere(9).aplicar("12345678"));
	}
}
