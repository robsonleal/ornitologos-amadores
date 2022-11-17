package com.sicredi.ornitologosbackend.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Avistamento  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data;
    private String horario;
    private String local;

    @ManyToOne
    @JoinColumn(name = "ave_id")
    private Ave ave;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
