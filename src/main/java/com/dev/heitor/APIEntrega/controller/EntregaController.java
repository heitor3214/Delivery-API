package com.dev.heitor.APIEntrega.controller;

import com.dev.heitor.APIEntrega.DTO.EntregaDTO;
import com.dev.heitor.APIEntrega.model.Entrega;
import com.dev.heitor.APIEntrega.service.ClienteService;
import com.dev.heitor.APIEntrega.service.EntregaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Entregas")
public class EntregaController {


    private final EntregaService entregaService;
    private final ClienteService clienteService;

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<EntregaDTO>> listar(){
        List<EntregaDTO> list = entregaService.findAll();

        return ResponseEntity.ok(list);
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public ResponseEntity<EntregaDTO> listarPorId(@PathVariable Long id){
        EntregaDTO entrega = entregaService.findById(id);

        return ResponseEntity.ok(entrega);
    }

    @Transactional
    @PostMapping()
    public ResponseEntity<EntregaDTO> save(@Valid @RequestBody EntregaDTO entregaDTO) {
        EntregaDTO entrega = entregaService.save(entregaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(entrega);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        entregaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<EntregaDTO> update(@PathVariable Long id, @RequestBody EntregaDTO entregaDTO) {
        EntregaDTO entregaUpdate = entregaService.updateById(id, entregaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(entregaUpdate);
    }

}
