package com.sicredi.ornitologosbackend.repositories;

import com.sicredi.ornitologosbackend.entities.Aves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvesRepository extends JpaRepository<Aves, Long> {
}
