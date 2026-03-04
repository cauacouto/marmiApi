package com.coutodev.marmiMvp.domain.Parceiros;

import com.coutodev.marmiMvp.DTO.ParceiroRequest;
import com.coutodev.marmiMvp.DTO.ParceiroResponse;
import com.coutodev.marmiMvp.Exception.RegraNegocioException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParceiroService {

private final ParceiroRepository parceiroRepository;


    public ParceiroService(ParceiroRepository parceiroRepository) {
        this.parceiroRepository = parceiroRepository;
    }

    public Parceiro findByParceiroId(UUID id){
        return this.parceiroRepository.findById(id)
                .orElseThrow(()-> new RegraNegocioException("parcceiro não encontrado"));
    }

    public ParceiroResponse CriarParceiro(ParceiroRequest request){
       Parceiro parceiro = new Parceiro(request);
       Parceiro salvo = parceiroRepository.save(parceiro);
       return new ParceiroResponse(salvo);




    }
}
