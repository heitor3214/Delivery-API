package com.dev.heitor.APIEntrega.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_entrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "codigo_rastreio", nullable = false, unique = true)
    private UUID codigoRastreio = UUID.randomUUID();


    @Column(name = "peso", nullable = false)
    private double peso;

    @NotNull
    @Column(name = "preco")
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "data_criacao")
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @Column(name = "data_entrega_realizada")
    private LocalDateTime dataEntregaRealizada;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cep", column = @Column(name = "cep_origem")),
            @AttributeOverride(name = "logradouro", column = @Column(name = "logradouro_origem")),
            @AttributeOverride(name = "numero", column = @Column(name = "numero_origem")),
            @AttributeOverride(name = "complemento", column = @Column(name = "complemento_origem"))
    })
    private Endereco enderecoDeOrigem;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cep", column = @Column(name = "cep_destino")),
            @AttributeOverride(name = "logradouro", column = @Column(name = "logradouro_destino")),
            @AttributeOverride(name = "numero", column = @Column(name = "numero_destino")),
            @AttributeOverride(name = "complemento", column = @Column(name = "complemento_destino"))
    })
    private Endereco enderecoDeDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
}
