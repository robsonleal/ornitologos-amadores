package com.sicredi.ornitologosbackend.repositories;

import com.sicredi.ornitologosbackend.entities.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@Sql("classpath:insert_usuarios.sql")
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void deveRetornarUsuarioPeloId(){

        var usuario= Usuario.builder()
                .id(1L)
                .email("test@gmail.com")
                .nome("test")
                .senha("$2a$12$Dct0YyQfmCVCiOgcAcUW3.j9iqTZzyycWyb0J1abWSlAsqmYMllzC")
                .build();

        assertThat(usuarioRepository.findById(1L).get())
                .isEqualTo(usuario);
    }

}