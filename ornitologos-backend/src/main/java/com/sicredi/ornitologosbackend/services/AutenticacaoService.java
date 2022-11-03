package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.UsuarioCadastroDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioLoginDto;

public interface AutenticacaoService {

    UsuarioDto autenticarUsuario(UsuarioLoginDto usuarioLogin);
    UsuarioDto findByEmail(String email);
    UsuarioDto cadastrar(UsuarioCadastroDto usuarioCadastroDto);
}
