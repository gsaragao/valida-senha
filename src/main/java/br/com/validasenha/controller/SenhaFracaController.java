package br.com.validasenha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.validasenha.dto.Param;
import br.com.validasenha.validador.ValidadorSenha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * A classe SenhaFracaResource é responsável por expor o 
 * serviço REST de senha fraca.
 *
 * @author gustavoaragao
 */
@Api(tags = "Senha Fraca")
@RestController
@RequestMapping("/senhafraca")
public class SenhaFracaController {

	@Autowired
	@Qualifier("fraca")
	private ValidadorSenha validadorSenhaFraca;
	
	private static Logger logger = LoggerFactory.getLogger(SenhaFracaController.class);
	
	/**
	 * Método responsável expor o serviço e validar a senha 
	 * através de um critério fraco pré-determinado.
	 *
	 * @param param O objeto param com a senha
	 * @return true se a senha for validada com sucesso 
	 */
	@ApiOperation(value = "Valida uma senha com critério fraco")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> validar( @RequestBody Param param) {
		try {
			return ResponseEntity.ok(validadorSenhaFraca.validar(param.getSenha()));
		} catch (Exception e) {
			logger.debug("Erro:" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
