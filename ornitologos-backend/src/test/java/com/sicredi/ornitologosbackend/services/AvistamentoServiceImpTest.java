package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.entities.Avistamento;
import com.sicredi.ornitologosbackend.repositories.AvistamentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AvistamentoServiceImpTest {

    @Mock
    private AvistamentoRepository avistamentoRepository;

    @InjectMocks
    private AvistamentoServiceImp avistamentoServiceImp;

    @Test
    void deveRetornarTodosAvistamentosCadastradosPeloUsuario(){

        var avistamento= Avistamento.builder()
                .local("teste")
                .build();


        var avistamento2= Avistamento.builder()
                .local("teste2")
                .build();


        var avistamento3= Avistamento.builder()
                .local("teste3")
                .build();


        var avistamentos= Set.of(avistamento,avistamento3);

        when(avistamentoRepository.findByUsuarioId(1L))
                .thenReturn(avistamentos);

        assertThat(avistamentoServiceImp.listarTodos(1L))
                .isEqualTo(avistamentos);

        verify(avistamentoRepository).findByUsuarioId(1L);
    }


}