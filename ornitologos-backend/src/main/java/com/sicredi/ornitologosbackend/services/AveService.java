package com.sicredi.ornitologosbackend.services;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.repositories.AveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AveService {

    @Autowired
    private AveRepository aveRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public List<AveDto> listarAves(){
        List<Ave> obj = aveRepository.findAll();
        return obj.stream().map(x-> new AveDto(x)).collect(Collectors.toList());
    }
    public List<AveDto> encontrarAves(String busca){
//        String sql =
//                ("SELECT id, nomePt, nomeEn, nomeLt, tamanho, genero, cor, familia, habitat FROM Ave WHERE lower(cor) LIKE '%"+busca
//                        +"%' OR upper(cor) LIKE '%"+ busca
//                        +"%' OR lower(genero) LIKE '%"+busca
//                        +"%' OR upper(genero) LIKE '%"+busca
//                        +"%' OR lower(familia) LIKE '%"+busca
//                        +"%' OR upper(familia) LIKE '%"+busca
//                        +"%' OR lower(habitat) LIKE '%"+busca
//                        +"%' OR upper(habitat) LIKE '%"+busca
//                        +"%' OR lower(nomeEn) LIKE '%"+busca
//                        +"%' OR upper(nomeEn) LIKE '%"+busca
//                        +"%' OR lower(nomeLt) LIKE '%"+busca
//                        +"%' OR upper(nomeLt) LIKE '%"+busca
//                        +"%' OR lower(nomePt) LIKE '%"+busca
//                        +"%' OR upper(nomePt) LIKE '%"+busca
//                        +"%'");
//        Query query = entityManager.createQuery(sql);
//        List<Ave> result = query.getResultList();
//        return result.stream().map(x-> new AveDto(x)).collect(Collectors.toList());
        List<Ave> aves = aveRepository.encontrarAves("%"+busca+"%");
        return aves.stream().map(x-> new AveDto(x)).collect(Collectors.toList());
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
