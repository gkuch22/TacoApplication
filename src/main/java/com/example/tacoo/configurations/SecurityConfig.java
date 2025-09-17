package com.example.tacoo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.tacoo.models.User;
import com.example.tacoo.repositories.UserRepository;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepository) {
		return username -> {
			User user = userRepository.findByUsername(username);
			if(user != null) return user;
			
			throw new UsernameNotFoundException("User " + username + "not found");
		};
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/design", "/orders").hasRole("USER")
            .requestMatchers("/", "/**").permitAll()
        )
        .formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/design", true)
        )
        .logout(logout -> logout
        	.logoutSuccessUrl("/"))
        
        .headers(headers -> headers.frameOptions(frame -> frame.disable()))
        .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))

		.build();
	}
	
	
	
	
	
	
}
