package com.techeazy.studentmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.techeazy.studentmanagement.service.MyUserDetailsService;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MysecurityConfig {
	
	@Autowired
	private MyUserDetailsService userDetailService;
	
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	return http
			.csrf(customizer -> customizer.disable())
			.authorizeHttpRequests(request -> request.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults())
			.sessionManagement(session ->
						session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.build();

	}
	

	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailService);
		return provider;
	}
	
	
}