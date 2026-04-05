package com.dev.heitor.APIEntrega.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnderecoDTO(
        @NotBlank(message = "É nescesario CEP")
        @Size(max = 20, message = "O Cep deve ter no maximo 20 caracteres")
        String cep,

        @NotBlank(message = "O logradouro é obrigatório")
        String logradouro,

        @NotBlank(message = "O número é obrigatório")
        String numero,

        String complemento
    ){
}
