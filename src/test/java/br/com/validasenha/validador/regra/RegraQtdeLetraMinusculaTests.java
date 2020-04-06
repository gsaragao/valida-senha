package br.com.validasenha.validador.regra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A classe RegraQtdeLetraMinusculaTests verifica se a regra de quantidade de letras
 * minúsculas está sendo aplicada corretamente.
 *
 * @author gustavoaragao
 */
public class RegraQtdeLetraMinusculaTests {

	/**
	 * Teste quantidade minima no parametro.
	 */
	@Test
	public void testeQuantidadeMinimaNoParametro() {
		Assertions.assertEquals(1 ,new RegraQtdeLetraMinuscula(1).getQuantidadeMinima());
		Assertions.assertNotEquals(2 ,new RegraQtdeLetraMinuscula(3).getQuantidadeMinima());
		Assertions.assertEquals(20 ,new RegraQtdeLetraMinuscula(20).getQuantidadeMinima());
	}
	
	/**
	 * Teste aplicar regra de quantidade de de letras minúsculas
	 */
	@Test
	public void testeAplicarRegraQuantidadeLetrasMinusculas() {
		Assertions.assertTrue(new RegraQtdeLetraMinuscula(1).aplicar("a"));
		Assertions.assertTrue(new RegraQtdeLetraMinuscula(2).aplicar("bc"));
		Assertions.assertTrue(new RegraQtdeLetraMinuscula(3).aplicar("aee3"));
		Assertions.assertTrue(new RegraQtdeLetraMinuscula(4).aplicar("Ass#df"));
		Assertions.assertTrue(new RegraQtdeLetraMinuscula(1).aplicar("712n6371"));
		
		Assertions.assertFalse(new RegraQtdeLetraMinuscula(1).aplicar(""));
		Assertions.assertFalse(new RegraQtdeLetraMinuscula(1).aplicar("AAAA"));
		Assertions.assertFalse(new RegraQtdeLetraMinuscula(1).aplicar("1"));
		Assertions.assertFalse(new RegraQtdeLetraMinuscula(1).aplicar("#"));
	}
}
