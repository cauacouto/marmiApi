package com.coutodev.marmiMvp.DTO;

import com.coutodev.marmiMvp.enums.TipoCozinha;
import com.coutodev.marmiMvp.enums.TipoDocumento;

import java.util.UUID;

public record ParceiroRequest(String nomeLoja, TipoDocumento tipoDocumento, String endereco, TipoCozinha tipoCozinha) {
}
