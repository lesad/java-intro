package com.experiment.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((authz) -> {
      authz.requestMatchers("/admin/**").authenticated();
      authz.requestMatchers("/users/**").permitAll();
    }).httpBasic(withDefaults())
      .cors(cors -> cors.disable())
      .csrf(csrf -> csrf.disable());

    return http.build();
  }
}
