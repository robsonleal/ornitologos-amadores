package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.AvistamentoDto;
import com.sicredi.ornitologosbackend.entities.Avistamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface AvistamentoService {

    Set<Avistamento> listarTodos(Long id);

    Avistamento inserirAvistamento(Avistamento avistamento);

    Avistamento converteDoDTO(AvistamentoDto avistamentoDto);
}
