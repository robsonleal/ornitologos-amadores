package com.sicredi.ornitologosbackend.configs;

import com.sicredi.ornitologosbackend.dtos.UsuarioDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioLoginDto;
import com.sicredi.ornitologosbackend.services.AutenticacaoService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class UsuarioAuthenticationProvider {
    @Value("${security.jwt.token.secret-key}")
    private String secretKey;
    private final AutenticacaoService autenticacaoService;

    @PostConstruct
    protected void init() {
        secretKey= Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String criarToken(String login) {
        Claims claims = Jwts.claims().setSubject(login);

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hora

        return Jwts.builder()
                .setClaims(claims)
                .claim("roles", Collections.singleton(new SimpleGrantedAuthority("USUARIO")))
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication validarToken(String token) {
        String email = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();


        UsuarioDto userDto= autenticacaoService.getUsuarioDtoPeloEmail(email);

        return new UsernamePasswordAuthenticationToken(userDto,
                null,
                Collections.singleton(new SimpleGrantedAuthority("USUARIO")));
    }

    public Authentication validarCredenciais(UsuarioLoginDto usuarioLoginDto) {
        UsuarioDto user = autenticacaoService.autenticarUsuario(usuarioLoginDto);
        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

}
