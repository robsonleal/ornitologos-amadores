package com.sicredi.ornitologosbackend.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private  static  final String[] USUARIO= {"/api/v1/usuarios"};
    private  static  final String[] PUBLIC= {"/api/v1/auth/login","/api/v1/auth/cadastro"};

    private final UsuarioAuthenticationEntryPoint userAuthenticationEntryPoint;
    private final UsuarioAuthenticationProvider userAuthenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
                .and()
                .addFilterBefore(new EmailSenhaAuthFilter(userAuthenticationProvider), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtAuthFilter(userAuthenticationProvider), EmailSenhaAuthFilter.class)
                .authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(USUARIO).hasAnyRole("USUARIO")
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .csrf().disable();

        return http.build();
    }
}
