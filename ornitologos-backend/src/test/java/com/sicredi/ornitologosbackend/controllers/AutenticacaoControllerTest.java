package com.sicredi.ornitologosbackend.controllers;

import com.google.gson.Gson;
import com.sicredi.ornitologosbackend.security.UsuarioAuthenticationProvider;
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
    void deveRetornar201AoCadastrarUsuario() throws Exception {

        var usuarioCadastro= UsuarioCadastroDto.builder()
                .email("teste@gmafds")
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

        mockMvc.perform(post("/v1/auth/cadastro")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("teste@gmail"))
                .andExpect(jsonPath("$.nome").value("nome"));

        verify(autenticacaoService).cadastrar(usuarioCadastro);
    }

    @Test
    void deveRetornar400QuandoEmailVazio() throws Exception {

        var usuarioCadastro= UsuarioCadastroDto.builder()
                .nome("nome")
                .senha("123")
                .build();

        var json= new Gson().toJson(usuarioCadastro);

        mockMvc.perform(post("/v1/auth/cadastro")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.[0].message").value("O email é obrigatório!"));
    }


    @Test
    void deveRetornar400QuandoEmailInvalido() throws Exception {

        var usuarioCadastro= UsuarioCadastroDto.builder()
                .nome("nome")
                .email("teste")
                .senha("123")
                .build();

        var json= new Gson().toJson(usuarioCadastro);

        mockMvc.perform(post("/v1/auth/cadastro")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.[0].message").value("Email inválido!"));
    }

    @Test
    void deveRetornar400QuandoSenhaVazia() throws Exception {

        var usuarioCadastro= UsuarioCadastroDto.builder()
                .email("teste@gmail")
                .nome("nome")
                .build();

        var json= new Gson().toJson(usuarioCadastro);

        mockMvc.perform(post("/v1/auth/cadastro")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.[0].message").value("A senha é obrigatória!"));
    }

    @Test
    void deveRetornar400QuandoNomeMenorQue3Letras() throws Exception {

        var usuarioCadastro= UsuarioCadastroDto.builder()
                .email("teste@gmail")
                .senha("teste")
                .nome("n")
                .build();

        var json= new Gson().toJson(usuarioCadastro);

        mockMvc.perform(post("/v1/auth/cadastro")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.[0].message").value("O nome deve ter pelo menos 3 letras!"));
    }

}