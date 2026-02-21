package com.coutodev.marmiMvp.DTO;

import java.util.List;
import java.util.UUID;

public record CriarPedidoDTO(UUID usuarioId,
                             List<ItemPedidoDto> itens) {
}
