package com.market.marketplace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .csrf(csrf -> csrf.disable())
      .cors(cors -> cors.configure(http))
      .authorizeHttpRequests(authorize -> authorize
        .dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()
        .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
        .requestMatchers(HttpMethod.POST, "/api/usuarios/login").permitAll()
        .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
        .requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
        .anyRequest().permitAll()
      )
      .build();
  }
}