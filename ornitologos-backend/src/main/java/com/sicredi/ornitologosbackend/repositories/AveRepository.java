package com.sicredi.ornitologosbackend.repositories;

import com.sicredi.ornitologosbackend.entities.Ave;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AveRepository extends JpaRepository<Ave, Long> {
    Optional<Ave> findByNomePtContainingOrNomeEnContainingOrNomeLtContainingOrCorOrHabitat(String nomePt, String nomeEn, String nomeLt, String cor, String habitat);
}
