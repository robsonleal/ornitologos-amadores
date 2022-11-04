package com.sicredi.ornitologosbackend.dtos;

import com.sicredi.ornitologosbackend.entities.Ave;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;

@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
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

    public AveDto(Ave ave) {

    }
}
