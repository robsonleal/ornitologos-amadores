package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.repositories.AveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AveService {

    private final AveRepository aveRepository;
    public Ave inserirAve(Ave ave){
        return aveRepository.save(ave);
    }

    public List<Ave> encontrarAve(String busca){
        return aveRepository
                .findByNomePtContainingOrNomeEnContainingOrNomeLtContainingOrCorOrHabitat
                        (busca, busca, busca, busca, busca);
    }
}
