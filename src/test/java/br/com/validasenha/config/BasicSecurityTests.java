package br.com.validasenha.config;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.validasenha.dto.Param;
import br.com.validasenha.util.UsuarioUtil;


/**
 * A classe BasicSecurityTests.
 *
 * @author gustavoaragao
 */
@SpringBootTest
@AutoConfigureMockMvc
public class BasicSecurityTests extends WebSecurityConfigurerAdapter {

	@Autowired
	private MockMvc mockMvc;

	/**
	 * Teste acesso protegido.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeAcessoProtegido() throws Exception {
		this.mockMvc.perform(post("/senhafraca").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(new Param()))).andExpect(status().isUnauthorized());
		this.mockMvc.perform(post("/senhaforte").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(new Param()))).andExpect(status().isUnauthorized());
	}

	/**
	 * Teste acessar senha fraca autenticado.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeAcessarSenhaFracaAutenticado() throws Exception {
		this.mockMvc.perform(post("/senhafraca").with(httpBasic(UsuarioUtil.USUARIO, 
				UsuarioUtil.SENHA))).andExpect(authenticated());
	}

	/**
	 * Teste acessar senha forte autenticado. 
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeAcessarSenhaForteAutenticado() throws Exception {
		this.mockMvc.perform(post("/senhaforte").with(httpBasic(UsuarioUtil.USUARIO, 
				UsuarioUtil.SENHA))).andExpect(authenticated());
	}
	
	/**
	 * Teste acesso usuario invalido.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testeAcessoUsuarioInvalido() throws Exception {
		MvcResult result = this.mockMvc.perform(formLogin().user("invalid").password("invalid"))
				.andExpect(unauthenticated()).andReturn();
		
		Assertions.assertEquals(HttpStatus.UNAUTHORIZED.value(), result.getResponse().getStatus());
	}
}