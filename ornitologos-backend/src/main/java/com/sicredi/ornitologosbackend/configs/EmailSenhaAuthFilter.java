package com.sicredi.ornitologosbackend.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sicredi.ornitologosbackend.dtos.UsuarioLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class EmailSenhaAuthFilter extends OncePerRequestFilter {

    private  final UsuarioAuthenticationProvider userAuthenticationProvider;
    private static final ObjectMapper MAPPER= new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if ("/api/v1/auth/login".equals(request.getServletPath())
                && HttpMethod.POST.matches(request.getMethod())) {
            UsuarioLoginDto credentialsDto = MAPPER.readValue(request.getInputStream(), UsuarioLoginDto.class);

            try {
                SecurityContextHolder.getContext()
                        .setAuthentication(userAuthenticationProvider.validarCredenciais(credentialsDto));
            } catch (RuntimeException e) {
                SecurityContextHolder.clearContext();
                throw e;
            }
        }

        filterChain.doFilter(request, response);
    }

}
