package com.sicredi.ornitologosbackend.repositories;

import com.sicredi.ornitologosbackend.entities.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@Sql("classpath:insert_usuarios.sql")
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Optional<Usuario> usuario;

    @BeforeEach
    void setUp(){
       usuario= Optional.of(Usuario.builder()
                .id(1L)
                .email("test@gmail.com")
                .nome("test")
                .senha("$2a$12$Dct0YyQfmCVCiOgcAcUW3.j9iqTZzyycWyb0J1abWSlAsqmYMllzC")
                .build());
    }

    @Test
    void deveRetornarUsuarioPeloEmail(){

        assertThat(usuarioRepository.findByEmail("test@gmail.com"))
                .isEqualTo(usuario);
    }

    @Test
    void deveRetornarOptionalVazioQuandoEmailNaoEstiverCadastrado(){

        assertThat(usuarioRepository.findByEmail("test2@gmail.com"))
                .isEqualTo(Optional.empty());
    }
}