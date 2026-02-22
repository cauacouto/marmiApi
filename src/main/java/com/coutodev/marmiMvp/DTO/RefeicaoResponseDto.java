package com.coutodev.marmiMvp.DTO;

import java.math.BigDecimal;

public record RefeicaoResponseDto (
      Long id,
      String nome,
        String descricao,
         Double calorias,
         Double proteinas,
         Double gorduras,
        BigDecimal preco,
        Boolean ativo,
         ParceiroResponseDto parceiro

){

}



