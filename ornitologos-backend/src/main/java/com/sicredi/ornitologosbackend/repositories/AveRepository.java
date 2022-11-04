package com.sicredi.ornitologosbackend.repositories;

import com.sicredi.ornitologosbackend.entities.Ave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AveRepository extends JpaRepository<Ave, Long> {
}
