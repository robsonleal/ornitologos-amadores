package com.sicredi.ornitologosbackend.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Avistamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private LocalDateTime horario;
    private String local;

    @ManyToOne
    @JoinColumn(name = "ave_id")
    private Ave ave;

}
