package com.sicredi.ornitologosbackend.controllers;

import com.sicredi.ornitologosbackend.configs.UsuarioAuthenticationProvider;
import com.sicredi.ornitologosbackend.dtos.UsuarioCadastroDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioDto;
import com.sicredi.ornitologosbackend.services.AutenticacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;
    private final UsuarioAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> login(@AuthenticationPrincipal UsuarioDto usuario) {
        usuario.setToken(userAuthenticationProvider.criarToken(usuario.getEmail()));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/cadastro")
    public  ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioCadastroDto usuario){

        UsuarioDto createdUser=autenticacaoService.cadastrar(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
