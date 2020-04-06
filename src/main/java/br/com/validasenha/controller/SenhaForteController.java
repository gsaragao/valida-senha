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
 * A classe SenhaForteController é responsável por expor o 
 * serviço REST de senha forte.
 *
 * @author gustavoaragao
 */
@Api(tags = "Senha Forte")
@RestController
@RequestMapping("/senhaforte")
public class SenhaForteController {

	@Autowired
	@Qualifier("forte")
	private ValidadorSenha validadorSenhaForte;
	
	private static Logger logger = LoggerFactory.getLogger(SenhaForteController.class);
	
	/**
	 * Método responsável expor o serviço e validar a senha 
	 * através de um critério forte pré-determinado.
	 *
	 * @param param O objeto param com a senha
	 * @return true se a senha for validada com sucesso 
	 */
	@ApiOperation(value = "Valida uma senha com critério forte")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
		    	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> validar( @RequestBody Param param) {
		try {
			return ResponseEntity.ok(validadorSenhaForte.validar(param.getSenha()));
		} catch (Exception e) {
			logger.debug("Erro:" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
