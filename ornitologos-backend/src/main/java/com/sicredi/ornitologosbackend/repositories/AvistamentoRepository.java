package com.sicredi.ornitologosbackend.repositories;

import com.sicredi.ornitologosbackend.entities.Avistamento;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

@Repository
public interface AvistamentoRepository extends JpaRepository<Avistamento, Long> {
}
