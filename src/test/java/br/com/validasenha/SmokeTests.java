package br.com.validasenha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.validasenha.controller.SenhaForteController;
import br.com.validasenha.controller.SenhaFracaController;

/**
 * A classe SmokeTests.
 *
 * @author gustavoaragao
 */
@SpringBootTest
public class SmokeTests {
	
	@Autowired
	private SenhaForteController senhaForteController;
	
	@Autowired
	private SenhaFracaController senhaFracaController;

	/**
	 * Testa se os controllers foram carregados no contexto da aplicacão.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void contexLoads() throws Exception {
		Assertions.assertNotNull(senhaForteController);
		Assertions.assertNotNull(senhaFracaController);
	}
}
