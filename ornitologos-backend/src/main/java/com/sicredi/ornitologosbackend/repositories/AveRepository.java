package com.sicredi.ornitologosbackend.repositories;

import com.sicredi.ornitologosbackend.entities.Ave;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AveRepository extends JpaRepository<Ave, Long> {
    @Override
    Ave save(Ave ave);

    List<Ave> findByNomePtContainingOrNomeEnContainingOrNomeLtContainingOrCorOrHabitat(String nomePt, String nomeEn, String nomeLt, String cor, String habitat);
}
