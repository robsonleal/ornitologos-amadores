package com.sicredi.ornitologosbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioCadastroDto {

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3,message = "O nome deve ter pelo menos 3 letras!")
    private String nome;

    @Email(message = "Email inválido!")
    @NotBlank(message = "O email é obrigatório!")
    private String email;

    @NotBlank(message = "A senha é obrigatória!")
    private String senha;
}
