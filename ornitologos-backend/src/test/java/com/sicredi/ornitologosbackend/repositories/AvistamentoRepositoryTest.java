package com.sicredi.ornitologosbackend.repositories;

import com.sicredi.ornitologosbackend.entities.Avistamento;
import com.sicredi.ornitologosbackend.entities.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class AvistamentoRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AvistamentoRepository avistamentoRepository;

    private Set<Avistamento> avistamentosUsuario;

    @Test
    void deveRetornarAvistamentosPeloIdDoUsuarioPersistido(){

        var avistamento= Avistamento.builder()
                .local("teste")
                .build();


        var avistamento2= Avistamento.builder()
                .local("teste2")
                .build();


        var avistamento3= Avistamento.builder()
                .local("teste3")
                .build();

        avistamentoRepository.save(avistamento);
        avistamentoRepository.save(avistamento2);
        avistamentoRepository.save(avistamento3);

        avistamentosUsuario = Set.of(avistamento,avistamento3);


        var usuario= Optional.of(Usuario.builder()
                .id(1L)
                .email("test@gmail.com")
                .nome("test")
                .avistamentos(avistamentosUsuario)
                .senha("$2a$12$Dct0YyQfmCVCiOgcAcUW3.j9iqTZzyycWyb0J1abWSlAsqmYMllzC")
                .build());

        usuarioRepository.save(usuario.get());

        assertThat(avistamentoRepository.findByUsuarioId(1L))
                .isEqualTo(avistamentosUsuario);
    }

}