package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.repositories.AveRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AveService {

    @Autowired
    private AveRepository aveRepository;

    private final ModelMapper modelMapper;

    public Page<AveDto> listarAves(Pageable pageable){
        Page<Ave> ave = aveRepository.findAll(pageable);
        return ave.map(x-> new AveDto(x));
    }
    public Page<AveDto> encontrarAves(String busca, Pageable pageable){
        Page<Ave> aves = aveRepository.encontrarAves("%"+busca+"%", pageable);

        return aves.map(x-> new AveDto(x));
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
        AveDto aveDto = new AveDto(entity);
        return aveDto;
    }

}
