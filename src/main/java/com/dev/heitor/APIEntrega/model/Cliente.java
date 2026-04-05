package com.dev.heitor.APIEntrega.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_cliente")
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_completo", nullable = false, length = 150)
    private String nomeClienteCompleto;

    @Column(name = "numero_de_telefone", nullable = false, length = 100)
    private String numeroTelefone;

    @Column(name = "email", length = 100)
    private String email;

    @Embedded
    private Endereco enderecoOrigem;

}
