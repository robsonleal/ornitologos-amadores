package com.sicredi.ornitologosbackend.repositories;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.entities.Usuario;
import com.sicredi.ornitologosbackend.services.AveServiceImpl;
import lombok.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class AveRepositoryTeste {

    @Autowired
    private AveRepository aveRepository;

    private Pageable pageable;

    Page<Ave> aves;

    @Test
    void deveRetornarTodasAsAves(){
        var ave = Ave.builder()
                .id(1L)
                .nomePt("Beija-Flor")
                .nomeEn("nomeEN")
                .nomeLt("nomeLt")
                .tamanho("18")
                .familia("Passaros")
                .cor("Azul")
                .genero("Masculino")
                .habitat("Tropical")
                .build();

        var ave2 = Ave.builder()
                .nomePt("Papagaio")
                .nomeEn("nomeEN")
                .nomeLt("nomeLt")
                .tamanho("18")
                .familia("Passaros")
                .cor("amarelo")
                .genero("Feminino")
                .habitat("Tropical")
                .build();

        aveRepository.save(ave);
        List<Ave> list = new ArrayList<>();
        list.add(ave);
        assertThat(aveRepository.findAll()).isEqualTo(list);
    }
}
