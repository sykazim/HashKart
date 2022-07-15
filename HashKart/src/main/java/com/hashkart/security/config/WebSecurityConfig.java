package com.hashkart.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
			.username("kazim2jobs25@gmail.com")
			.password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
			.roles("USER")
			.build();
		UserDetails admin = User.builder()
			.username("admin")
			.password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
			.roles("USER", "ADMIN")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	/*
	 * @Bean protected WebSecurityCustomizer webSecurityCustomizer() throws
	 * Exception { return (auth) -> auth.build() .passwordEncoder(new
	 * BCryptPasswordEncoder()) .withUser("kazim2jobs25@gmail.com")
	 * .password("abcde123") .roles("USER") .and() .withUser("admin")
	 * .password("...") .roles("ADMIN") ; }
	 */
	 
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception { http.authorizeRequests() .anyRequest().authenticated() .and()
	 * .httpBasic();
	 * 
	 * return http.build(); }
	 */
	}

