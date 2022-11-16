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

       var aveEntity= aveRepository.save(modelMapper.map(aveDto,Ave.class));

        return modelMapper.map(aveEntity,AveDto.class);
    }

}
