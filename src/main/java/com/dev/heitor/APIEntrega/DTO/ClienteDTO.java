package com.dev.heitor.APIEntrega.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteDTO(
        Long id,

        @NotBlank(message = "O nome é obrigatorio")
        @Size(max = 150)
        String nomeClienteCompleto,

        @NotBlank(message = "O numero de telefone é obrigatorio")
        @Size(max = 100)
        String numeroTelefone,

        @Email(message = "O e-mail está fromatado errado")
        @NotBlank(message = "O e-mail é obrigatori")
        @Size(max = 100)
        String email,

        EnderecoDTO enderecoOrigem
    ){
}
