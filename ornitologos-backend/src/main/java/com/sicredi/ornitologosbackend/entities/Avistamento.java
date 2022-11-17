package com.sicredi.ornitologosbackend.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Avistamento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private LocalDateTime horario;
    private String local;

    @ManyToOne
    @JoinColumn(name = "ave_id")
    private Ave ave;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
