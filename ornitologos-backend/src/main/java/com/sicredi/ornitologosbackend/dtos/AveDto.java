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
public class AveDto {

    private Long id;
    private String nomePt;
    private String nomeEn;
    private String nomeLt;
    private Integer tamanho;
    private String genero;
    private String cor;
    private String familia;
    private String habitat;
}
