package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.AvistamentoDto;
import com.sicredi.ornitologosbackend.entities.Avistamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AvistamentoService {

    List<Avistamento> listarTodos();

    Avistamento inserirAvistamento(Avistamento avistamento);

    Avistamento converteDoDTO(AvistamentoDto avistamentoDto);

    LocalDate inserirDataLocal(LocalDate localDate);

    LocalDateTime inserirDataLocalTime(LocalDateTime localDateTime);

}