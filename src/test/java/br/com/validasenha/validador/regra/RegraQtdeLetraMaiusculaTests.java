package br.com.validasenha.validador.regra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A classe RegraQtdeLetraMaiusculaTests verifica se a regra de quantidade de letras
 * maiuscula está sendo aplicada corretamente.
 *
 * @author gustavoaragao
 */
public class RegraQtdeLetraMaiusculaTests {

	/**
	 * Teste quantidade minima no parametro.
	 */
	@Test
	public void testeQuantidadeMinimaNoParametro() {
		Assertions.assertEquals(1 ,new RegraQtdeLetraMaiuscula(1).getQuantidadeMinima());
		Assertions.assertNotEquals(2 ,new RegraQtdeLetraMaiuscula(3).getQuantidadeMinima());
		Assertions.assertEquals(20 ,new RegraQtdeLetraMaiuscula(20).getQuantidadeMinima());
	}
	
	/**
	 * Teste aplicar regra de quantidade de de letras maiuscula
	 */
	@Test
	public void testeAplicarRegraQuantidadeLetraMaiuscula() {
		Assertions.assertTrue(new RegraQtdeLetraMaiuscula(1).aplicar("A"));
		Assertions.assertTrue(new RegraQtdeLetraMaiuscula(2).aplicar("BC"));
		Assertions.assertTrue(new RegraQtdeLetraMaiuscula(3).aplicar("AGH3"));
		Assertions.assertTrue(new RegraQtdeLetraMaiuscula(4).aplicar("aSS#DF"));
		Assertions.assertTrue(new RegraQtdeLetraMaiuscula(1).aplicar("712B6371"));
		
		Assertions.assertFalse(new RegraQtdeLetraMaiuscula(1).aplicar(""));
		Assertions.assertFalse(new RegraQtdeLetraMaiuscula(1).aplicar("aaaa"));
		Assertions.assertFalse(new RegraQtdeLetraMaiuscula(1).aplicar("1"));
		Assertions.assertFalse(new RegraQtdeLetraMaiuscula(1).aplicar("#"));
	}
}
