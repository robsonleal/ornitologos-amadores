package com.sicredi.ornitologosbackend.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="aves")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Aves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nomePortugues")
    @NotNull
    private String nomePt;

    @Column(name = "nomeIngles")
    @NotNull
    private String nomeEn;

    @Column(name = "nomeLatim")
    @NotNull
    private String nomeLt;

    @Column(name = "tamanho")
    @NotNull
    private Integer tamanho;

    @Column(name = "genero")
    @NotNull
    private String genero;

    @Column(name = "cor")
    @NotNull
    private String cor;

    @Column(name = "familia")
    @NotNull
    private String familia;

    @Column(name = "habitat")
    @NotNull
    private String habitat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aves aves = (Aves) o;
        return Objects.equals(id, aves.id) && Objects.equals(nomePt, aves.nomePt) && Objects.equals(nomeEn, aves.nomeEn) && Objects.equals(nomeLt, aves.nomeLt) && Objects.equals(tamanho, aves.tamanho) && Objects.equals(genero, aves.genero) && Objects.equals(cor, aves.cor) && Objects.equals(familia, aves.familia) && Objects.equals(habitat, aves.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomePt, nomeEn, nomeLt, tamanho, genero, cor, familia, habitat);
    }
}
