package com.dev.heitor.APIEntrega.DTO;

import com.dev.heitor.APIEntrega.model.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record EntregaDTO(
        Long id,

        UUID codigoRastreio,

        @NotNull(message = "É obrigatorio o peso da entrega")
        @Positive(message = "Deve ser um valor positivo")
        double peso,

        @NotNull(message = "É nescesario por um preco")
        @Positive(message = "O valor deve ser positivo")
        BigDecimal preco,

        @NotNull(message = "É nescesario por o estatus atual da entrega")
        Status status,

        @NotNull(message = "É preciso informar a data de criação")
        LocalDateTime dataCriacao,

        @NotNull(message = "É preciso de endereco de origem")
        @Valid
        EnderecoDTO enderecoDeOrigem,

        @NotNull(message = "É preciso de uma origem")
        @Valid
        EnderecoDTO enderecoDeDestino,

        @NotNull(message = "O ID do cliente é obrigatorio")
        Long clienteId


) {
}
