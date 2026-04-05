package com.dev.heitor.APIEntrega.mapper;

import com.dev.heitor.APIEntrega.DTO.ClienteDTO;
import com.dev.heitor.APIEntrega.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") //Isso faz o spring criar o bean sozinho
public interface ClienteMapper {

    ClienteDTO toDTO(Cliente cliente);

    Cliente toEntity(ClienteDTO clienteDTO);
}
