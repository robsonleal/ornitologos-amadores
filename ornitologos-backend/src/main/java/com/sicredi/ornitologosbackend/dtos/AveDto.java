package com.sicredi.ornitologosbackend.dtos;

import com.sicredi.ornitologosbackend.entities.Ave;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;

@Getter
@ToString
public class AveDto {

    private Long id;
    private String nomePt;
    private String nomeEn;
    private String nomeLt;
    private String tamanho;
    private String genero;
    private String cor;
    private String familia;
    private String habitat;

    public AveDto() {
    }

    public AveDto(Ave entity) {
        this.id = entity.getId();
        this.nomePt = entity.getNomePt();
        this.nomeEn = entity.getNomeEn();
        this.nomeLt = entity.getNomeLt();
        this.tamanho = entity.getTamanho();
        this.genero = entity.getGenero();
        this.cor = entity.getCor();
        this.familia = entity.getFamilia();
        this.habitat = entity.getHabitat();
    }

    public AveDto(Long id, String nomePt, String nomeEn, String nomeLt, String tamanho, String genero, String cor, String familia, String habitat) {
        this.id = id;
        this.nomePt = nomePt;
        this.nomeEn = nomeEn;
        this.nomeLt = nomeLt;
        this.tamanho = tamanho;
        this.genero = genero;
        this.cor = cor;
        this.familia = familia;
        this.habitat = habitat;
    }
}
