package com.vanhuy.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.cors(Customizer.withDefaults())
//            .csrf().disable()
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .antMatchers("/api/**").permitAll()
//                    .anyRequest().authenticated()
//            )
//        ;

        return http.build();
    }

}
