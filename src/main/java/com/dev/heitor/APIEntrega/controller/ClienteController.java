package com.dev.heitor.APIEntrega.controller;

import com.dev.heitor.APIEntrega.DTO.ClienteDTO;
import com.dev.heitor.APIEntrega.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar() {
        List<ClienteDTO> lista = clienteService.findAll();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {

        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<ClienteDTO> save(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteSaved = clienteService.save(clienteDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSaved);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteAutalizado = clienteService.updateById(id, clienteDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteAutalizado);
    }
}
