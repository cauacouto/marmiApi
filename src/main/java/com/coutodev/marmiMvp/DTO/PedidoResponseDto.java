package com.coutodev.marmiMvp.DTO;

import com.coutodev.marmiMvp.enums.StatusPedido;

import java.math.BigDecimal;
import java.util.UUID;

public record PedidoResponseDto(UUID id,
                                BigDecimal valorTotal,
                                StatusPedido pedido) {
}
