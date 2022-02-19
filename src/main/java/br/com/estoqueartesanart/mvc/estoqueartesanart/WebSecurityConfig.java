package br.com.estoqueartesanart.mvc.estoqueartesanart;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;




@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
		.antMatchers("/**/*.css", "/**/*.js", "/**/*.png" ).permitAll()
		.antMatchers("/estoque/**").hasAnyRole("ADM", "ESTOQUE")
		.antMatchers("/usuario/**").hasAnyRole("ADM", "USUARIO")
		
		
		.and()
		.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/entrar", true)
			.permitAll()
			.and()
			.csrf().disable()
			.logout(logout -> logout.logoutUrl("/sair")); 
		
		
		
	}
	
	
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
			
			BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
			
	
		/*	UserDetails user =
				 User.builder()
				.username("usuario")
						.password(enconder.encode("usuario"))
						.roles("USUARIO")
						.build();
			*/
			
	
			
			auth.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(enconder);
		
	//	.withUser(user);
		}
	
	


}
