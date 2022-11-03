package com.sicredi.ornitologosbackend.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AvesDto {
    private Long id;

    @Column(name = "nomePortugues")
    @NotNull
    private String nomePt;

    @Column(name = "nomeIngles")
    @NotNull
    private String nomeEn;

    @Column(name = "nomeLatim")
    @NotNull
    private String nomeLt;

    @Column(name = "tamanho")
    @NotNull
    private Integer tamanho;

    @Column(name = "genero")
    @NotNull
    private String genero;

    @Column(name = "cor")
    @NotNull
    private String cor;

    @Column(name = "familia")
    @NotNull
    private String familia;

    @Column(name = "habitat")
    @NotNull
    private String habitat;
}
