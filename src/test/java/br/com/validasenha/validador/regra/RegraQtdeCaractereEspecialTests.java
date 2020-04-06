package br.com.validasenha.validador.regra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A classe RegraQtdeCaractereEspecialTests verifica se a regra de quantidade de 
 * caractere especial está sendo aplicada corretamente.
 *
 * @author gustavoaragao
 */
public class RegraQtdeCaractereEspecialTests {

	/**
	 * Teste quantidade minima no parametro.
	 */
	@Test
	public void testeQuantidadeMinimaNoParametro() {
		Assertions.assertEquals(1 ,new RegraQtdeCaractereEspecial(1).getQuantidadeMinima());
		Assertions.assertNotEquals(2 ,new RegraQtdeCaractereEspecial(3).getQuantidadeMinima());
		Assertions.assertEquals(20 ,new RegraQtdeCaractereEspecial(20).getQuantidadeMinima());
	}
	
	/**
	 * Teste aplicar regra de quantidade de caractere especial.
	 */
	@Test
	public void testeAplicarRegraQuantidadeCaractereEspecial() {
		Assertions.assertTrue(new RegraQtdeCaractereEspecial(1).aplicar("#aaaa"));
		Assertions.assertTrue(new RegraQtdeCaractereEspecial(2).aplicar("#$"));
		Assertions.assertTrue(new RegraQtdeCaractereEspecial(3).aplicar("123!%*aa"));
		Assertions.assertTrue(new RegraQtdeCaractereEspecial(4).aplicar("mAd&+({aaaa"));
		Assertions.assertTrue(new RegraQtdeCaractereEspecial(1).aplicar("mAd&+({aaaa"));
		
		Assertions.assertFalse(new RegraQtdeCaractereEspecial(1).aplicar(""));
		Assertions.assertFalse(new RegraQtdeCaractereEspecial(1).aplicar(" "));
		Assertions.assertFalse(new RegraQtdeCaractereEspecial(2).aplicar("#aaaa"));
		Assertions.assertFalse(new RegraQtdeCaractereEspecial(3).aplicar("123$&"));
	}
}
