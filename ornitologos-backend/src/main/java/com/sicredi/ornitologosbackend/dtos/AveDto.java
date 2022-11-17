package com.sicredi.ornitologosbackend.dtos;

import com.sicredi.ornitologosbackend.types.Habitat;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private List<Habitat> habitat=new ArrayList<>();
}
