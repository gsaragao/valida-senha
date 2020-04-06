package br.com.validasenha.validador;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.validasenha.validador.regra.Regra;
import br.com.validasenha.validador.regra.RegraQtdeCaractere;
import br.com.validasenha.validador.regra.RegraQtdeCaractereEspecial;
import br.com.validasenha.validador.regra.RegraQtdeDigito;
import br.com.validasenha.validador.regra.RegraQtdeLetraMaiuscula;
import br.com.validasenha.validador.regra.RegraQtdeLetraMinuscula;

/**
 * A classe ValidadorSenhaForteTests valida a utilização das regras pré-definidas
 * para senha fraca .
 *
 * @author gustavoaragao
 */
public class ValidadorSenhaFracaTests {

	private ValidadorSenhaFraca validadorSenhaFraca = new ValidadorSenhaFraca();
	
	/**
	 * Teste validacao de senha fraca com diversos criterios.
	 */
	@Test
	public void testeValidacaoSenhaComDiversosCriterios() {
		Assertions.assertFalse(validadorSenhaFraca.validar(""));
		Assertions.assertFalse(validadorSenhaFraca.validar(" "));
		Assertions.assertFalse(validadorSenhaFraca.validar(null));
		Assertions.assertFalse(validadorSenhaFraca.validar("Ab"));
		Assertions.assertFalse(validadorSenhaFraca.validar("aa"));
		Assertions.assertFalse(validadorSenhaFraca.validar("11"));
		Assertions.assertFalse(validadorSenhaFraca.validar("222"));
		Assertions.assertFalse(validadorSenhaFraca.validar("4444"));
		Assertions.assertFalse(validadorSenhaFraca.validar("AAAA"));
		
		Assertions.assertTrue(validadorSenhaFraca.validar("aa11"));
		Assertions.assertTrue(validadorSenhaFraca.validar("cA3e"));
	}
	
	/**
	 * Teste quantidade de regas do validador.
	 */
	@Test
	public void testeQuantidadeRegras() {
		Assertions.assertEquals(3, validadorSenhaFraca.getListaRegras().size());
	}
	
	/**
	 * Teste verifica se as regra estao presentes.
	 */
	@Test
	public void testeVerificaSeAsRegraEstaoPresentes() {
		
		Assertions.assertTrue(verificaClasseRegraPresente(RegraQtdeCaractere.class, 
				validadorSenhaFraca.getListaRegras()));
		Assertions.assertTrue(verificaClasseRegraPresente(RegraQtdeDigito.class, 
				validadorSenhaFraca.getListaRegras()));
		Assertions.assertTrue(verificaClasseRegraPresente(RegraQtdeLetraMinuscula.class, 
				validadorSenhaFraca.getListaRegras()));
	}
	
	/**
	 * Teste verifica se tem regra não pertencente.
	 */
	@Test
	public void testeVerificaSeTemRegraQueNaoPertence() {
		
		Assertions.assertFalse(verificaClasseRegraPresente(RegraQtdeLetraMaiuscula.class, 
				validadorSenhaFraca.getListaRegras()));
		Assertions.assertFalse(verificaClasseRegraPresente(RegraQtdeCaractereEspecial.class, 
				validadorSenhaFraca.getListaRegras()));
	}
	
	/**
	 * Verifica classe regra está presente na lista.
	 *
	 * @param regraTestada A regra testada
	 * @param listaRegras a lista regras
	 * @return true, se tem a regra na lista
	 */
	private boolean verificaClasseRegraPresente(Class<?> clazz, List<Regra> listaRegras) {
		return listaRegras.stream().anyMatch(r -> r.getClass().equals(clazz));
	}
	
}
