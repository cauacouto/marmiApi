package com.coutodev.marmiMvp.DTO;

import java.math.BigDecimal;
import java.util.UUID;

public record CriarRefeicaoDto(String nome,
                               String descricao,
                               Double calorias,
                               Double proteinas,
                               Double gorduras,
                               BigDecimal preco,
                               Boolean ativo,
                               UUID parceiroId) {
}
