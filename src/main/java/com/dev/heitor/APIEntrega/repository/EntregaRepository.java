package com.dev.heitor.APIEntrega.repository;

import com.dev.heitor.APIEntrega.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    boolean existsByCodigoRastreio(UUID codigoRastreio);
}
