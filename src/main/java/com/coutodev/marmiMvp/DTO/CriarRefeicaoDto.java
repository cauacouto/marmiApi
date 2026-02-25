package com.coutodev.marmiMvp.DTO;

import java.math.BigDecimal;

public record CriarRefeicaoDto(String nome,
                               String descricao,
                               Double calorias,
                               Double proteinas,
                               Double gorduras,
                               BigDecimal preco
                               ) {
}
