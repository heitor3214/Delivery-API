package com.dev.heitor.APIEntrega.repository;

import com.dev.heitor.APIEntrega.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByEmail(String email);

}
