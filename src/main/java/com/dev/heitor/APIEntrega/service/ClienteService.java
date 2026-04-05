package com.dev.heitor.APIEntrega.service;

import com.dev.heitor.APIEntrega.DTO.ClienteDTO;
import com.dev.heitor.APIEntrega.mapper.ClienteMapper;
import com.dev.heitor.APIEntrega.model.Cliente;
import com.dev.heitor.APIEntrega.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Transactional(readOnly = true)
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().
                stream()
                .map(clienteMapper::toDTO)
                .toList();

    }

    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findById(Long id) {
        return clienteRepository.
                findById(id).
                map(clienteMapper::toDTO);
    }

    @Transactional
    public ClienteDTO save(ClienteDTO clienteDTO) {

        if (clienteRepository.existsByEmail(clienteDTO.email())) {
            throw new RuntimeException("Este e-mail já está cadastrado!");
        }

        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        Cliente clienteSaved = clienteRepository.save(cliente);
        return clienteMapper.toDTO(clienteSaved);
    }

    @Transactional
    public void delete(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Não existe cliente com o id: " + id);
        }
        clienteRepository.deleteById(id);
    }

    @Transactional
    public ClienteDTO updateById(Long id, ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não existente!"));

        if (!clienteExistente.getEmail().equals(clienteDTO.email()) && clienteRepository.existsByEmail(clienteDTO.email())) {
            throw new RuntimeException("Este novo e-mail já esté sendo usado por outro cliente!");
        }

        clienteExistente.setNomeClienteCompleto(clienteDTO.nomeClienteCompleto());
        clienteExistente.setNumeroTelefone(clienteDTO.numeroTelefone());
        clienteExistente.setEmail(clienteDTO.email());

        return clienteMapper
                .toDTO(clienteRepository.save(clienteExistente));
    }
}
