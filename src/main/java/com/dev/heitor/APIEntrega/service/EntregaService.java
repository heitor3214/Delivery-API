package com.dev.heitor.APIEntrega.service;

import com.dev.heitor.APIEntrega.DTO.EntregaDTO;
import com.dev.heitor.APIEntrega.mapper.EntregaMapper;
import com.dev.heitor.APIEntrega.model.Cliente;
import com.dev.heitor.APIEntrega.model.Entrega;
import com.dev.heitor.APIEntrega.repository.ClienteRepository;
import com.dev.heitor.APIEntrega.repository.EntregaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntregaService {

    private final EntregaRepository entregaRepository;
    private final EntregaMapper entregaMapper;
    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<EntregaDTO> findAll() {
        return entregaRepository
                .findAll()
                .stream()
                .map(entregaMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public EntregaDTO findById(Long id) {
        return entregaRepository
                .findById(id)
                .map(entregaMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Entrega not found!"));
    }

    @Transactional
    public EntregaDTO save(EntregaDTO entregaDTO) {

        Cliente cliente = clienteRepository.findById(entregaDTO.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente not found!"));

        Entrega entrega = entregaMapper.toEntity(entregaDTO);

        entrega.setCliente(cliente);
        entrega.setEnderecoDeOrigem(cliente.getEnderecoOrigem());

        entrega = entregaRepository.save(entrega);

        return entregaMapper.toDTO(entrega);
    }

    @Transactional
    public void deleteById(Long id) {
        if (!entregaRepository.existsById(id)) {
            throw new RuntimeException("Esse user não existe!");
        }

        entregaRepository.deleteById(id);
    }

    @Transactional
    public EntregaDTO updateById(Long id, EntregaDTO entregaDTO) {

        Entrega entregaExistente = entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada!"));


        Cliente cliente = clienteRepository.findById(entregaDTO.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));


        if (entregaDTO.codigoRastreio() != null &&
                !entregaDTO.codigoRastreio().equals(entregaExistente.getCodigoRastreio()) &&
                entregaRepository.existsByCodigoRastreio(entregaDTO.codigoRastreio())) {

            throw new RuntimeException("Código de rastreio já está em uso!");
        }


        entregaExistente.setCodigoRastreio(entregaDTO.codigoRastreio());
        entregaExistente.setPeso(entregaDTO.peso());
        entregaExistente.setPreco(entregaDTO.preco());
        entregaExistente.setStatus(entregaDTO.status());


        entregaExistente.setDataCriacao(entregaDTO.dataCriacao());


        entregaExistente.setCliente(cliente);


        entregaExistente.setEnderecoDeOrigem(cliente.getEnderecoOrigem());


        Entrega nova = entregaMapper.toEntity(entregaDTO);
        entregaExistente.setEnderecoDeDestino(nova.getEnderecoDeDestino());

        return entregaMapper.toDTO(entregaRepository.save(entregaExistente));
    }
}
