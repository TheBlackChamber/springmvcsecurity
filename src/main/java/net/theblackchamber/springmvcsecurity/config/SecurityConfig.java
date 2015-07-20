package net.theblackchamber.springmvcsecurity.config;

import net.theblackchamber.springmvcsecurity.security.DbAuthenticationProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DbAuthenticationProvider authenticationProvider;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(authenticationProvider);
//		auth.inMemoryAuthentication().withUser("blackchamber").password("123456")
//				.roles("USER");
//		auth.inMemoryAuthentication().withUser("admin").password("123456")
//				.roles("ADMIN");
		
	}

	@Override
	public void configure(WebSecurity builder) throws Exception {
		builder.ignoring().antMatchers("/static/css/**", "/static/fonts/**", "/static/js/**", "/static/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
				.anyRequest().hasAnyRole("USER","ADMIN")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/")
				.and()
			.logout()
				.permitAll();

	}
}