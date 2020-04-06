package br.com.validasenha.validador.regra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A classe RegraQtdeDigitoTests verifica se a regra de quantidade de digitos
 * está sendo aplicada corretamente.
 *
 * @author gustavoaragao
 */
public class RegraQtdeDigitoTests {

	/**
	 * Teste quantidade minima no parametro.
	 */
	@Test
	public void testeQuantidadeMinimaNoParametro() {
		Assertions.assertEquals(1 ,new RegraQtdeDigito(1).getQuantidadeMinima());
		Assertions.assertNotEquals(2 ,new RegraQtdeDigito(3).getQuantidadeMinima());
		Assertions.assertEquals(20 ,new RegraQtdeDigito(20).getQuantidadeMinima());
	}
	
	/**
	 * Teste aplicar regra de quantidade de digitos.
	 */
	@Test
	public void testeAplicarRegraCaracterEspecial() {
		Assertions.assertTrue(new RegraQtdeDigito(1).aplicar("1"));
		Assertions.assertTrue(new RegraQtdeDigito(2).aplicar("99"));
		Assertions.assertTrue(new RegraQtdeDigito(3).aplicar("123"));
		Assertions.assertTrue(new RegraQtdeDigito(4).aplicar("1234"));
		Assertions.assertTrue(new RegraQtdeDigito(1).aplicar("7126371"));
		
		Assertions.assertFalse(new RegraQtdeDigito(1).aplicar(""));
		Assertions.assertFalse(new RegraQtdeDigito(1).aplicar("aaaa"));
		Assertions.assertFalse(new RegraQtdeDigito(1).aplicar("x"));
	}
}
