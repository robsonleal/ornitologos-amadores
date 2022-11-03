package com.sicredi.ornitologosbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLoginDto {

    private Long id;
    private String email;
    private String senha;
    private String token;
}
