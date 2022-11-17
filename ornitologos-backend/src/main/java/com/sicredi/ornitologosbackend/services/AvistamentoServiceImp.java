package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.AvistamentoDto;
import com.sicredi.ornitologosbackend.entities.Avistamento;
import com.sicredi.ornitologosbackend.repositories.AvistamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AvistamentoServiceImp implements AvistamentoService {

    private final AvistamentoRepository avistamentoRepository;

    @Override
    public Set<Avistamento> listarTodos(Long id) {
        return avistamentoRepository.findByUsuarioId(id);
    }

    @Override
    public Avistamento inserirAvistamento(Avistamento avistamento) {
        return avistamentoRepository.save(avistamento);
    }

    @Override
    public Avistamento converteDoDTO(AvistamentoDto avistamentoDto) {
        return new Avistamento(avistamentoDto.getId(),avistamentoDto.getData(),avistamentoDto.getHorario(),avistamentoDto.getLocal(),avistamentoDto.getAve(),null);
    }

    @Override
    public LocalDate inserirDataLocal(LocalDate localDate) {
        return localDate;
    }

    @Override
    public LocalDateTime inserirDataLocalTime(LocalDateTime localDateTime) {
        return localDateTime;
    }
}
