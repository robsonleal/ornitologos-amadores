package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.repositories.AveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AveService {

    private final AveRepository aveRepository;

    public AveDto inserirAve(AveDto dto){
        Ave entity = new Ave();
        entity.setNomePt(dto.getNomePt());
        entity.setNomeEn(dto.getNomeEn());
        entity.setNomeLt(dto.getNomeLt());
        entity.setTamanho(dto.getTamanho());
        entity.setCor(dto.getCor());
        entity.setFamilia(dto.getFamilia());
        entity.setGenero(dto.getGenero());
        entity.setHabitat(dto.getHabitat());
        entity = aveRepository.save(entity);
        return new AveDto(entity);
    }

    public List<Ave> encontrarAve(String busca){
        List<Ave> obj = aveRepository.findByNomePtContainingOrNomeEnContainingOrNomeLtContainingOrCorOrHabitat(busca,busca,busca,busca,busca);
        return obj;
    }
}
