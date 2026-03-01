package com.coutodev.marmiMvp.DTO;

import com.coutodev.marmiMvp.domain.Parceiros.Parceiro;
import com.coutodev.marmiMvp.enums.TipoCozinha;
import com.coutodev.marmiMvp.enums.TipoDocumento;

import java.util.UUID;

public record ParceiroResponse(UUID id ,String nomeLoja, TipoDocumento tipoDocumento, String endereco, TipoCozinha tipoCozinha) {


    public ParceiroResponse (Parceiro parceiro){
        this(
                parceiro.getId(),
                parceiro.getNomeLoja(),
                parceiro.getTipoDocumento(),
                parceiro.getEndereco(),
                parceiro.getTipoCozinha()
        );
    }
}
