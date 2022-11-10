package com.sicredi.ornitologosbackend.repositories;

import com.sicredi.ornitologosbackend.entities.Ave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AveRepository extends JpaRepository<Ave, Long> {

    @Query(value = "SELECT u FROM Ave u WHERE lower(cor) like :busca OR upper(cor) like :busca OR lower(familia) like :busca OR upper(familia) like :busca OR lower(genero) like :busca OR upper(genero) like :busca OR lower(habitat) like :busca OR upper(habitat) like :busca OR lower(tamanho) like :busca OR upper(tamanho) like :busca OR lower(nomePt) like :busca OR upper(nomePt) like :busca OR lower(nomeEn) like :busca OR upper(nomeEn) like :busca OR lower(nomeLt) like :busca OR upper(nomeLt) like :busca")
    List<Ave> encontrarAves(@Param("busca") String busca, Pageable pageable);

    @Override
    Page<List<Ave>> findAll(Pageable pageable);

//    Page<List<AveDto>> PageImpl(List<AveDto> aveDto, Pageable pageable);

}
