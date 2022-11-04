package com.sicredi.ornitologosbackend.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "aves")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nomePortugues")
    @NotNull
    @Setter
    private String nomePt;

    @Column(name = "nomeIngles")
    @NotNull
    @Setter
    private String nomeEn;

    @Column(name = "nomeLatim")
    @NotNull
    @Setter
    private String nomeLt;

    @Column(name = "tamanho")
    @NotNull
    @Setter
    private Integer tamanho;

    @Column(name = "genero")
    @NotNull
    @Setter
    private String genero;

    @Column(name = "cor")
    @NotNull
    @Setter
    private String cor;

    @Column(name = "familia")
    @NotNull
    @Setter
    private String familia;

    @Column(name = "habitat")
    @NotNull
    @Setter
    private String habitat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ave ave = (Ave) o;
        return Objects.equals(id, ave.id) && Objects.equals(nomePt, ave.nomePt) && Objects.equals(nomeEn, ave.nomeEn) && Objects.equals(nomeLt, ave.nomeLt) && Objects.equals(tamanho, ave.tamanho) && Objects.equals(genero, ave.genero) && Objects.equals(cor, ave.cor) && Objects.equals(familia, ave.familia) && Objects.equals(habitat, ave.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomePt, nomeEn, nomeLt, tamanho, genero, cor, familia, habitat);
    }
}
