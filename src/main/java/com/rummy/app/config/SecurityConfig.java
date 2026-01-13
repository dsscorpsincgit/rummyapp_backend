package com.rummy.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // 🔹 Disable CSRF for Postman testing
            .csrf(csrf -> csrf.disable())

            // 🔹 Permit all requests to /api/auth, /api/users, /api/kyc
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/users/**").permitAll()
                .requestMatchers("/api/kyc/**").permitAll()
                .anyRequest().authenticated()
            )

            // 🔹 Disable default login form
            .formLogin(form -> form.disable())

            // 🔹 Disable basic auth
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
