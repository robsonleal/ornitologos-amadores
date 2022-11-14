package com.sicredi.ornitologosbackend.dtos;

import com.sicredi.ornitologosbackend.entities.Ave;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvistamentoDto {
    private Long id;
    private LocalDate data;
    private LocalDateTime horario;
    private String local;
    private Ave ave;
}