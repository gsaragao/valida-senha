package br.com.validasenha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * A classe SwaggerConfig é responsável por habilitar o Swagger na aplicação.
 *
 * @author gustavoaragao
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Método que retorna o Docket com os endpoints disponíveis.
	 *
	 * @return o docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.validasenha.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	/**
	 * Método que retorna as informações básicas da página do Swagger
	 *
	 * @return a api info
	 */
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Valida Senha API")
	            .description("API para validação de senha")
	            .version("1.0.0")
	            .contact(new Contact("Gustavo Aragao", "https://br.linkedin.com/in/gustavoaragao", 
	            		"gsaragao@gmail.com"))
	            .build();
	}
}
