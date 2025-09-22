
  package com.scm.scm.config;
  
  import java.util.Arrays; import java.util.List;
  
  import org.springframework.context.annotation.Bean; import
  org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.
  EnableWebSecurity; import org.springframework.security.core.userdetails.User;
  import org.springframework.security.core.userdetails.UserDetails; import
  org.springframework.security.core.userdetails.UserDetailsService; import
  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
  org.springframework.security.crypto.password.PasswordEncoder; import
  org.springframework.security.web.SecurityFilterChain;
  import org.springframework.security.provisioning.InMemoryUserDetailsManager;

  import com.scm.scm.service.UserService;
  
  @Configuration
  @EnableWebSecurity 
  @EnableMethodSecurity(prePostEnabled=true)
  public class SecurityConfig {
  
		
		  @Bean public InMemoryUserDetailsManager UserService() { UserDetails user
		  =User.withUsername("user").password(passwordEncoder().encode("0000")).roles(
		  "USER").build(); UserDetails admin =
		  User.withUsername("admin").password(passwordEncoder().encode("0000")).roles(
		  "ADMIN").build();
		  
		  
		  return new InMemoryUserDetailsManager(user,admin);
		  
		  
		  }
		 
  
  @Bean 
  public PasswordEncoder passwordEncoder() { 
	  return new BCryptPasswordEncoder(); }
   
		/*
		 * @Bean public DaoAuthenticationProvier authenticationProvider() {
		 * DaoAuthenticationProvider daoAuthenticationProvider = new
		 * DaoAuthenticationProvider();
		 */
	  
		
		  @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
		  Exception { http.csrf().disable() .authorizeHttpRequests().
		  anyRequest().authenticated().and().formLogin();
		 
  //httpBasic()formLogin()
  
  return http.build(); }
  
  }
 
