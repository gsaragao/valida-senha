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
 * para senha forte .
 *
 * @author gustavoaragao
 */
public class ValidadorSenhaForteTests {

	private ValidadorSenhaForte validadorSenhaForte = new ValidadorSenhaForte();
	
	/**
	 * Teste validacao de senha forte com diversos criterios.
	 */
	@Test
	public void testeValidacaoSenhaComDiversosCriterios() {
		Assertions.assertFalse(validadorSenhaForte.validar(""));
		Assertions.assertFalse(validadorSenhaForte.validar(" "));
		Assertions.assertFalse(validadorSenhaForte.validar(null));
		Assertions.assertFalse(validadorSenhaForte.validar("Ab"));
		Assertions.assertFalse(validadorSenhaForte.validar("aa"));
		Assertions.assertFalse(validadorSenhaForte.validar("12312312312123"));
		Assertions.assertFalse(validadorSenhaForte.validar("#######"));
		Assertions.assertFalse(validadorSenhaForte.validar("AAAAAAAAAAAA"));
		Assertions.assertFalse(validadorSenhaForte.validar("AbAB#########"));
		Assertions.assertFalse(validadorSenhaForte.validar("11"));
		Assertions.assertFalse(validadorSenhaForte.validar("agtp9!foo"));
		
		Assertions.assertTrue(validadorSenhaForte.validar("aaCC31#09"));
		Assertions.assertTrue(validadorSenhaForte.validar("AbTp9!foo"));
	}
	
	/**
	 * Teste quantidade de regas do validador.
	 */
	@Test
	public void testeQuantidadeRegras() {
		Assertions.assertEquals(5, validadorSenhaForte.getListaRegras().size());
	}
	
	/**
	 * Teste verifica se as regra estao presentes.
	 */
	@Test
	public void testeVerificaSeAsRegraEstaoPresentes() {
		
		Assertions.assertTrue(verificaClasseRegraPresente(RegraQtdeCaractere.class, 
				validadorSenhaForte.getListaRegras()));
		Assertions.assertTrue(verificaClasseRegraPresente(RegraQtdeDigito.class, 
				validadorSenhaForte.getListaRegras()));
		Assertions.assertTrue(verificaClasseRegraPresente(RegraQtdeLetraMaiuscula.class, 
				validadorSenhaForte.getListaRegras()));
		Assertions.assertTrue(verificaClasseRegraPresente(RegraQtdeLetraMinuscula.class, 
				validadorSenhaForte.getListaRegras()));
		Assertions.assertTrue(verificaClasseRegraPresente(RegraQtdeCaractereEspecial.class, 
				validadorSenhaForte.getListaRegras()));
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
