package com.sicredi.ornitologosbackend.dtos;

import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class AveDto {

    private Long id;
    private String nomePt;
    private String nomeEn;
    private String nomeLt;
    private String tamanho;
    private String genero;
    private String cor;
    private String familia;
    private String habitat;
}
