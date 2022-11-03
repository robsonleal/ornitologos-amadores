package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.UsuarioCadastroDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioLoginDto;

import com.sicredi.ornitologosbackend.entities.Usuario;
import com.sicredi.ornitologosbackend.exceptions.EmailJaCadastradoException;
import com.sicredi.ornitologosbackend.exceptions.EmailNaoEncontradoException;
import com.sicredi.ornitologosbackend.exceptions.SenhaInvalidaException;
import com.sicredi.ornitologosbackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;


@Service
@RequiredArgsConstructor
public class AutenticacaoServiceImpl implements AutenticacaoService{

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;
    private  final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto autenticarUsuario(UsuarioLoginDto usuarioLogin) {
        Usuario usuario = usuarioRepository.findByEmail(usuarioLogin.getEmail())
                .orElseThrow(EmailJaCadastradoException::new);

        if(isPasswordValido(usuarioLogin, usuario))
            return modelMapper.map(usuario, UsuarioDto.class);

        throw  new SenhaInvalidaException();
    }

    @Override
    public UsuarioDto getUsuarioDtoPeloEmail(String email) {

        Usuario user= usuarioRepository.findByEmail(email)
                .orElseThrow(EmailNaoEncontradoException::new);

        return  modelMapper.map(user,UsuarioDto.class);
    }

    @Override
    public UsuarioDto cadastrar(UsuarioCadastroDto usuarioCadastroDto) {

        if(usuarioJaCadastrado(usuarioCadastroDto))
            throw new EmailJaCadastradoException();

        Usuario usuarioEntity= modelMapper.map(usuarioCadastroDto,Usuario.class);
        usuarioEntity.setSenha(passwordEncoder.encode(CharBuffer.wrap(usuarioCadastroDto.getSenha())));

        Usuario usuarioSalvo= usuarioRepository.save(usuarioEntity);

        return  modelMapper.map(usuarioSalvo,UsuarioDto.class);
    }

    public boolean usuarioJaCadastrado(UsuarioCadastroDto usuarioCadastroDto) {
        return usuarioRepository.findByEmail(usuarioCadastroDto.getEmail()).isPresent();
    }

    public boolean isPasswordValido(UsuarioLoginDto usuarioLogin, Usuario user) {
        return passwordEncoder.matches(CharBuffer.wrap(usuarioLogin.getSenha()), user.getSenha());
    }

}
