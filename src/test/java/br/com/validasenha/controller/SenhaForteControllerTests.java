package br.com.validasenha.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.validasenha.dto.Param;
import br.com.validasenha.util.UsuarioUtil;

/**
 * A classe SenhaForteControllerTests teste a chamada do método principal
 * do controller com autenticação e validação da senha.
 *
 * @author gustavoaragao
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SenhaForteControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * Teste valida senha forte fora dos criterios.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeValidaSenhaForteForaDosCriterios() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/senhaforte")
			   .with(httpBasic(UsuarioUtil.USUARIO, UsuarioUtil.SENHA))
		       .contentType(MediaType.APPLICATION_JSON_VALUE)
		       .accept(MediaType.APPLICATION_JSON_VALUE)
		       .content(new ObjectMapper().writeValueAsString(new Param("teste12"))))
		       .andExpect(status().isOk())
			   .andExpect(content().string("false"));
	}
	
	/**
	 * Teste valida senha forte dentro dos criterios.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeValidaSenhaForteDentroDosCriterios() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/senhaforte")
			   .with(httpBasic(UsuarioUtil.USUARIO, UsuarioUtil.SENHA))
		       .contentType(MediaType.APPLICATION_JSON_VALUE)
		       .accept(MediaType.APPLICATION_JSON_VALUE)
		       .content(new ObjectMapper().writeValueAsString(new Param("AbTp9!foo"))))
		       .andExpect(status().isOk())
			   .andExpect(content().string("true"));
	}

}
