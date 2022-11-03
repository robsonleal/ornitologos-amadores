package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.UsuarioCadastroDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioLoginDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AutenticacaoServiceImpl implements AutenticacaoService{

    @Override
    public UsuarioDto autenticarUsuario(UsuarioLoginDto usuarioLogin) {
        return null;
    }

    @Override
    public UsuarioDto findByEmail(String email) {
        return null;
    }

    @Override
    public UsuarioDto cadastrar(UsuarioCadastroDto usuarioCadastroDto) {
        return null;
    }
}
