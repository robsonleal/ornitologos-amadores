package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.repositories.AveRepository;
import com.sicredi.ornitologosbackend.types.Habitat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class AveServiceImplTest {

    @InjectMocks
    private AveServiceImpl aveService;

    @Spy
    private ModelMapper modelMapper;

    @Mock
    private AveRepository aveRepository;

    @Test
    void deveConverterStringParaListaHabitat(){

        List<Habitat> habitats= Arrays.asList(Habitat.CCA,Habitat.CSA,Habitat.CAU);

        assertThat(aveService.converteStringParaListaHabitat("[CCA,CSA,CAU]"))
                .isEqualTo(habitats);
    }

    @Test
    void deveAdicionarAve(){

        List<Habitat> habitats= Arrays.asList(Habitat.CCA,Habitat.CSA,Habitat.CAU);
//        List<Habitat> habitats= new ArrayList<>();
//        habitats.add(Habitat.CCA);
//        habitats.add(Habitat.CSA);
//        habitats.add(Habitat.CAU);

        var aveDto= AveDto.builder()
                .cor("amarelo")
                .familia("familia")
                .nomeEn("en")
                .nomePt("pt")
                .habitat(habitats)
                .build();

        var ave= Ave.builder()
                .cor("amarelo")
                .familia("familia")
                .nomeEn("en")
                .nomePt("pt")
                .habitat("[CCA, CSA, CAU]")
                .build();

        var aveSalva= Ave.builder()
                .id(1L)
                .cor("amarelo")
                .familia("familia")
                .nomeEn("en")
                .nomePt("pt")
                .habitat("[CCA,CSA,CAU]")
                .build();

        var aveDtoRetorno= AveDto.builder()
                .id(1L)
                .cor("amarelo")
                .familia("familia")
                .nomeEn("en")
                .nomePt("pt")
                .habitat(habitats)
                .build();

        when(aveRepository.save(ave)).thenReturn(aveSalva);

        assertThat(aveService.inserirAve(aveDto))
                .isEqualTo(aveDtoRetorno);
    }

}