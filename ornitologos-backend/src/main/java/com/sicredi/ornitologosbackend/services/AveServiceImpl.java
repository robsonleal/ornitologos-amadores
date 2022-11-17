package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.repositories.AveRepository;
import com.sicredi.ornitologosbackend.types.Habitat;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AveServiceImpl implements AveService{
    private final AveRepository aveRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<AveDto> encontrarAves(String busca, Pageable pageable){
        Page<Ave> aves = aveRepository.encontrarAves("%"+busca+"%", pageable);
        return aves.map(x-> modelMapper.map(x,AveDto.class));
    }

    @Override
    public AveDto inserirAve(AveDto aveDto){

        var teste =modelMapper.map(aveDto,Ave.class);
       var aveEntity= aveRepository.save(modelMapper.map(aveDto,Ave.class));


       var habitats= converteStringParaListaHabitat(aveEntity.getHabitat());

        var ave= modelMapper.map(aveEntity,AveDto.class);

        ave.setHabitat(habitats);

        return ave;
    }

    public List<Habitat> converteStringParaListaHabitat(String habitat){

        return Arrays.stream(habitat.substring(1,habitat.length()-1)
                        .split(","))
                      .map(Habitat::valueOf)
                      .collect(Collectors.toList());
    }
}
