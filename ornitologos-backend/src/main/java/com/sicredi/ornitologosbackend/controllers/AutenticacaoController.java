package com.sicredi.ornitologosbackend.controllers;

import com.sicredi.ornitologosbackend.configs.UsuarioAuthenticationProvider;
import com.sicredi.ornitologosbackend.dtos.UsuarioCadastroDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioLoginDto;
import com.sicredi.ornitologosbackend.entities.Usuario;
import com.sicredi.ornitologosbackend.exceptions.SenhaInvalidaException;
import com.sicredi.ornitologosbackend.repositories.UsuarioRepository;
import com.sicredi.ornitologosbackend.services.AutenticacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;
    private final UsuarioAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> login(@AuthenticationPrincipal UsuarioDto usuario){
        usuario.setToken(userAuthenticationProvider.criarToken(usuario.getEmail()));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/cadastro")
    public  ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioCadastroDto usuario){

        UsuarioDto usuarioCadastrado=autenticacaoService.cadastrar(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCadastrado);
    }

    @GetMapping("/all")
    public ResponseEntity<String> listar(@AuthenticationPrincipal UsuarioDto usuarioLoginDto){
        return ResponseEntity.ok(usuarioLoginDto.getEmail());
    }

    @ExceptionHandler(SenhaInvalidaException.class)
    public ResponseEntity<String> handleModeloNaoExisteException(SenhaInvalidaException e){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("deu ruim");
    }
}
