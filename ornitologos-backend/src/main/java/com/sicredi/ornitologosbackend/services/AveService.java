package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.repositories.AveRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AveService {

    @Autowired
    private AveRepository aveRepository;

    private final ModelMapper modelMapper;

    public Page<List<Ave>> listarAves(Pageable pageable){
//        Page<List<Ave>> ave = aveRepository.findAll(pageable);
//        List<AveDto> dto = ave.stream().map(x-> new AveDto((Ave) x)).collect(Collectors.toList());
        return aveRepository.findAll(pageable);
    }
    public List<AveDto> encontrarAves(String busca, Pageable pageable){
        List<Ave> aves = aveRepository.encontrarAves("%"+busca+"%", pageable);
        return aves.stream().map(x-> new AveDto(x)).collect(Collectors.toList());
//        List<AveDto> aveDtos = aves.stream().map(ave -> modelMapper.map(ave, AveDto.class)).collect(Collectors.toList());
//        return aveDtos;
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
//        AveDto aveDto = new AveDto();
//        BeanUtils.copyProperties(dto, aveDto);
    }

}
