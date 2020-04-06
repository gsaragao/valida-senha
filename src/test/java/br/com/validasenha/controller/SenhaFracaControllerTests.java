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
 * A classe SenhaFracaControllerTests teste a chamada do método principal
 * do controller com autenticação e validação da senha.
 *
 * @author gustavoaragao
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SenhaFracaControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * Teste valida senha fraca fora dos criterios.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeValidaSenhaFracaForaDosCriterios() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/senhafraca")
			   .with(httpBasic(UsuarioUtil.USUARIO, UsuarioUtil.SENHA))
		       .contentType(MediaType.APPLICATION_JSON_VALUE)
		       .accept(MediaType.APPLICATION_JSON_VALUE)
		       .content(new ObjectMapper().writeValueAsString(new Param("123"))))
		       .andExpect(status().isOk())
			   .andExpect(content().string("false"));
	}
	
	/**
	 * Teste valida senha forte dentro dos criterios.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeValidaSenhaFracaDentroDosCriterios() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/senhafraca")
			   .with(httpBasic(UsuarioUtil.USUARIO, UsuarioUtil.SENHA))
		       .contentType(MediaType.APPLICATION_JSON_VALUE)
		       .accept(MediaType.APPLICATION_JSON_VALUE)
		       .content(new ObjectMapper().writeValueAsString(new Param("12a3"))))
		       .andExpect(status().isOk())
			   .andExpect(content().string("true"));
	}

}
