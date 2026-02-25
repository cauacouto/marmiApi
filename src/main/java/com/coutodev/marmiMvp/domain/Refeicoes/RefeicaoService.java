package com.coutodev.marmiMvp.domain.Refeicoes;

import com.coutodev.marmiMvp.DTO.CriarRefeicaoDto;
import com.coutodev.marmiMvp.DTO.RefeicaoResponseDto;
import com.coutodev.marmiMvp.Exception.RegraNegocioException;
import com.coutodev.marmiMvp.Mapper.RefeicaoMapper;
import com.coutodev.marmiMvp.domain.Parceiros.Parceiro;
import com.coutodev.marmiMvp.domain.Parceiros.ParceiroRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RefeicaoService {

    private final ParceiroRepository parceiroRepository;
    private final RefeicaoRepository refeicaoRepository;
    private final RefeicaoMapper  refeicaoMapper;

    public RefeicaoService(ParceiroRepository parceiroRepository, RefeicaoRepository refeicaoRepository, RefeicaoMapper refeicaoMapper) {
        this.parceiroRepository = parceiroRepository;
        this.refeicaoRepository = refeicaoRepository;
        this.refeicaoMapper = refeicaoMapper;
    }

    public RefeicaoResponseDto criarRefeicao(CriarRefeicaoDto dto, UUID id){
        Parceiro parceiro = parceiroRepository.findById(id)
                .orElseThrow(()-> new RegraNegocioException("parceiro não encontrado"));

        Refeicao refeicao = refeicaoMapper.toEntity(dto);
        refeicao.setParceiro(parceiro);
        Refeicao refeicaoSalva = refeicaoRepository.save(refeicao);

        return refeicaoMapper.toResponseDto(refeicaoSalva);
    }
}
