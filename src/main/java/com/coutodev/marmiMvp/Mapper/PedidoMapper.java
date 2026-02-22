package com.coutodev.marmiMvp.Mapper;

import com.coutodev.marmiMvp.DTO.CriarPedidoDTO;
import com.coutodev.marmiMvp.DTO.PedidoResponseDto;
import com.coutodev.marmiMvp.domain.Pedido.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    Pedido toEntity (CriarPedidoDTO dto);

    PedidoResponseDto toResponseDto (Pedido entity);
}
