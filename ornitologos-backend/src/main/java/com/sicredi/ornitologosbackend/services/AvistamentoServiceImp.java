package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.entities.Avistamento;
import com.sicredi.ornitologosbackend.repositories.AvistamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AvistamentoServiceImp implements AvistamentoService {

    private final AvistamentoRepository avistamentoRepository;

    @Override
    public List<Avistamento> listarTodos() {
        return avistamentoRepository.findAll();
    }

    @Override
    public Avistamento inserirAvistamento(Avistamento avistamento) {
        return avistamentoRepository.save(avistamento);
    }
}
