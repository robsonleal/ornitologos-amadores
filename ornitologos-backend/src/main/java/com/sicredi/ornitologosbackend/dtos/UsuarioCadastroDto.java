package com.sicredi.ornitologosbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioCadastroDto {

    private String nome;
    private String email;
    private String senha;
}
