package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.entities.Avistamento;

import java.util.List;

public interface AvistamentoService {

    List<Avistamento> listarTodos();

    Avistamento inserirAvistamento(Avistamento avistamento);
}
