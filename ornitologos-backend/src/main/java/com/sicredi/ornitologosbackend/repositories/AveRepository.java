package com.sicredi.ornitologosbackend.repositories;

import com.sicredi.ornitologosbackend.entities.Ave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AveRepository extends JpaRepository<Ave, Long> {

    @Query(value = "SELECT u FROM Ave u WHERE lower(cor) like :filtro " +
            "OR upper(cor) like :filtro OR lower(familia) like :filtro " +
            "OR upper(familia) like :filtro OR lower(genero) like :filtro " +
            "OR upper(genero) like :filtro OR lower(habitat) like :filtro " +
            "OR upper(habitat) like :filtro OR lower(tamanho) like :filtro " +
            "OR upper(tamanho) like :filtro OR lower(nomePt) like :filtro " +
            "OR upper(nomePt) like :filtro OR lower(nomeEn) like :filtro " +
            "OR upper(nomeEn) like :filtro OR lower(nomeLt) like :filtro " +
            "OR upper(nomeLt) like :filtro")
    Page<Ave> encontrarAves(@Param("filtro") String filtro, Pageable pageable);


}
