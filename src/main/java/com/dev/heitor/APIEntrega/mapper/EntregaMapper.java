package com.dev.heitor.APIEntrega.mapper;

import com.dev.heitor.APIEntrega.DTO.EntregaDTO;
import com.dev.heitor.APIEntrega.model.Entrega;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntregaMapper {

    @Mapping(source = "cliente.id", target = "clienteId")
    EntregaDTO toDTO(Entrega entrega);

    @Mapping(target = "cliente", ignore = true) // Ignora no toEntity, você setará o cliente no Service
    @Mapping(source = "clienteId", target = "cliente.id") // Opcional, se quiser que ele crie um objeto Cliente só com o ID
    Entrega toEntity(EntregaDTO entregaDTO);
}
