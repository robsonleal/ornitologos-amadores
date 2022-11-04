package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.repositories.AveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AveService {

    @Autowired
    private AveRepository aveRepository;

    public List<AveDto> listarAves(){
        List<Ave> obj = aveRepository.findAll();
        return obj.stream().map(x-> new AveDto(x)).collect(Collectors.toList());
    }
    public AveDto encontrarAve(String busca){
        Optional<Ave> obj = aveRepository
                .findByNomePtContainingOrNomeEnContainingOrNomeLtContainingOrCorOrHabitat
                        (busca,busca,busca,busca,busca);
        Ave entity = obj.orElseThrow(() -> new RuntimeException("entity not found"));
        return new AveDto(entity);
    }
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

}
