package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AveService {
    Page<AveDto> encontrarAves(String busca, Pageable pageable);
    AveDto inserirAve(AveDto dto);
}
