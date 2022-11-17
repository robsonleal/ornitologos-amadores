package com.sicredi.ornitologosbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvistamentoDto {
    private Long id;
    private String data;
    private String horario;
    private String local;
    private String ave;
}