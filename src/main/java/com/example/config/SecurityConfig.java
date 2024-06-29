package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	//AUTHENTICATION 
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		//AUTHENTICATION -- VALIDED USER NAME AND PASS Correct  THAN ASSIGN ROLE
//		auth.inMemoryAuthentication().withUser("A").password("{noop}B").authorities("ADMIN");
//		auth.inMemoryAuthentication().withUser("M").password("{noop}N").authorities("EMPLOYE");
//		auth.inMemoryAuthentication().withUser("X").password("{noop}y").authorities("STUDENT");
//	}
//	
//	//AUTHORIZATION
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	
//		//1.ACCESS  TO ALL, ACCESS BY AUTHENTECATION, ACCESS BY SPECIFIC ROLE
//		//2.LOGIN DEATEALS ---> DEAFUALT SUCCESS PAGE
//		//3.LOGOUT
//		//4.EX EXCEPTION HANDLING
//		
//		//1.--- Acces all
//		http.authorizeRequests()
//		.antMatchers("/home").permitAll() 
//		
//		//access by authentication
//		.antMatchers("/welcome").authenticated()
//		
//		//access for specific role
//		.antMatchers("/admin").hasAuthority("ADMIN")
//		.antMatchers("/emp").hasAuthority("EMPLOYE")
//		.antMatchers("/std").hasAuthority("STUDENT")
//		
//		//all req authenticated honi chahiye
//		.anyRequest().authenticated()
//		.and()
//		
//		//after success fully log in to move a welcome page
//		.formLogin().defaultSuccessUrl("/welocome",true)
//		
//		//logout 
//		.and()
//		.logout()
//		
//		//exception Handling
//		.and()
//		.exceptionHandling()
//		.accessDeniedPage("/denied");
//		
//	}
	//AUTHENTICATION
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("A").password("{noop}B").authorities("ADMIN");
			auth.inMemoryAuthentication().withUser("M").password("{noop}N").authorities("EMPLOYEE");
			auth.inMemoryAuthentication().withUser("X").password("{noop}Y").authorities("STUDENT");
		}
		
		
		//AUTHORIZATION
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			
			.antMatchers("/home", "/reg").permitAll()
			
			.antMatchers("/welcome").authenticated()
			.antMatchers("/admin").hasAuthority("ADMIN")
			.antMatchers("/emp","/emp/**").hasAuthority("EMPLOYEE")
			.antMatchers("/std","/std1").hasAuthority("STUDENT")
			
			
			
//			.anyRequest().authenticated()
			
			.and()
			
			.formLogin()
			.defaultSuccessUrl("/welcome", true)
			
			.and()
			
			.logout()
			
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			
			.and()
			.exceptionHandling()
		
			.accessDeniedPage("/denied");
			
			
		}
}
