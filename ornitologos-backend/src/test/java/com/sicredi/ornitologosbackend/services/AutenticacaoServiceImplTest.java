package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.UsuarioCadastroDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioDto;
import com.sicredi.ornitologosbackend.entities.Usuario;
import com.sicredi.ornitologosbackend.exceptions.EmailJaCadastradoException;
import com.sicredi.ornitologosbackend.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class AutenticacaoServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private AutenticacaoServiceImpl autenticacaoService;

    @Spy
    private ModelMapper modelMapper;

    @Spy
    private PasswordEncoder passwordEncoder;

    @Test
    void deveCadastrarUsuario(){
        var usuario= Usuario.builder()
                .email("teste3@gmail")
                .avistamentos(new HashSet<>())
                .build();

        var usuarioDto= UsuarioDto.builder()
                .email("teste3@gmail")
                .build();

        var usuarioCadastro= UsuarioCadastroDto.builder()
                .email("teste3@gmail")
                .senha("123")
                .build();

        when(usuarioRepository.findByEmail("teste3@gmail"))
                .thenReturn(Optional.empty());

        when(usuarioRepository.save(usuario))
                .thenReturn(usuario);

        assertThat(autenticacaoService.cadastrar(usuarioCadastro))
                .isEqualTo(usuarioDto);

        verify(usuarioRepository).findByEmail("teste3@gmail");
        verify(usuarioRepository).save(usuario);

    }

    @Test
    void deveRetornarUsuarioDtoPeloEmail(){

        var usuario=Usuario.builder()
                .id(1L)
                .nome("123")
                .email("test@gmail")
                .build();

        var usuarioDto=UsuarioDto.builder()
                .id(1L)
                .nome("123")
                .email("test@gmail")
                .build();

        when(usuarioRepository.findByEmail("test@gmail"))
                .thenReturn(Optional.ofNullable(usuario));

        assertThat(autenticacaoService.getUsuarioDtoPeloEmail("test@gmail"))
                .isEqualTo(usuarioDto);

        verify(usuarioRepository).findByEmail("test@gmail");
    }

    @Test
    void deveLancarEmailCadastradoExceptionQuandoEmailJaFoiCadastrado(){

        var usuario= Usuario.builder()
                .email("teste@gmail")
                .build();

        var usuarioCadastro= UsuarioCadastroDto.builder()
                .email("teste@gmail")
                .senha("123")
                .build();

        when(usuarioRepository.findByEmail("teste@gmail"))
                .thenReturn(Optional.ofNullable(usuario));

        assertThatExceptionOfType(EmailJaCadastradoException.class)
                .isThrownBy(()->autenticacaoService.cadastrar(usuarioCadastro));

        verify(usuarioRepository).findByEmail("teste@gmail");
    }

    @Test
    void deveRetornarTrueQuandoEmailJaCadastrado(){
        var usuario= Usuario.builder()
                .email("teste@gmail")
                .build();


        var usuarioCadastro= UsuarioCadastroDto.builder()
                .email("teste@gmail")
                .senha("123")
                .build();

        when(usuarioRepository.findByEmail("teste@gmail"))
                .thenReturn(Optional.ofNullable(usuario));

        assertThat(autenticacaoService.usuarioJaCadastrado(usuarioCadastro))
                .isTrue();
    }
}