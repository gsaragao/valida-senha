package br.com.validasenha.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * A classe BasicSecurity é responsável pela segurança da aplicação.
 *
 * @author gustavoaragao
 */
@Configuration
@EnableWebSecurity
public class BasicSecurity extends WebSecurityConfigurerAdapter {

	/**
	* {@inheritDoc}
	*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("senha").password("{noop}1234").roles("USER");
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.POST, "/**").hasRole("USER")
		.and().csrf().disable().formLogin().disable();
	}
}