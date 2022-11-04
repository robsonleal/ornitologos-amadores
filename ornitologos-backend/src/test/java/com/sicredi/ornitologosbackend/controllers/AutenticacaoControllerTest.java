package com.sicredi.ornitologosbackend.controllers;

import com.google.gson.Gson;
import com.sicredi.ornitologosbackend.configs.UsuarioAuthenticationProvider;
import com.sicredi.ornitologosbackend.dtos.UsuarioCadastroDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioDto;
import com.sicredi.ornitologosbackend.services.AutenticacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AutenticacaoController.class)
@AutoConfigureMockMvc(addFilters = false)
class AutenticacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioAuthenticationProvider usuarioAuthenticationProvider;

    @MockBean
    private AutenticacaoService autenticacaoService;

    @Test
    void deveCadastrarUsuario() throws Exception {

        var usuarioCadastro= UsuarioCadastroDto.builder()
                .email("teste@gmail")
                .nome("nome")
                .senha("123")
                .build();

        var usuarioDto= UsuarioDto.builder()
                .nome("nome")
                .email("teste@gmail")
                .build();

        when(autenticacaoService.cadastrar(usuarioCadastro))
                .thenReturn(usuarioDto);

        var json= new Gson().toJson(usuarioCadastro);

        mockMvc.perform(post("/api/v1/auth/cadastro")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("teste@gmail"))
                .andExpect(jsonPath("$.nome").value("nome"));

        verify(autenticacaoService).cadastrar(usuarioCadastro);
    }
}