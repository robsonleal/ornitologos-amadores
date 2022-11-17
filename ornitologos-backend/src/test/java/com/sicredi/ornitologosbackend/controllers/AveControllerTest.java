package com.sicredi.ornitologosbackend.controllers;

import com.google.gson.Gson;
import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.services.AveServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AveController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AveControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AveServiceImpl aveService;

    private Pageable pageable = PageRequest.of(0, 5);

    @Test
    public void deveRetornarTodasAsAves() throws Exception {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("nomePt").ascending());

        var ave = AveDto.builder()
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

        List<AveDto> lista = Collections.singletonList(ave);

        Page<AveDto> aveDto = new PageImpl<AveDto>(lista);

        when(aveService.encontrarAves("", pageable))
                .thenReturn(aveDto);

        var json= new Gson().toJson(aveDto);

        mockMvc.perform(get("/v1/aves/").param("q", "")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1L))
                .andExpect(jsonPath("$.content[0].nomePt").value("Beija-Flor"))
                .andExpect(jsonPath("$.content[0].nomeEn").value("nomeEN"))
                .andExpect(jsonPath("$.content[0].nomeLt").value("nomeLt"))
                .andExpect(jsonPath("$.content[0].tamanho").value("18"))
                .andExpect(jsonPath("$.content[0].familia").value("Passaros"))
                .andExpect(jsonPath("$.content[0].cor").value("Azul"))
                .andExpect(jsonPath("$.content[0].genero").value("Masculino"))
                .andExpect(jsonPath("$.content[0].habitat").value("Tropical"));

        verify(aveService).encontrarAves("", pageable);
    }
}
