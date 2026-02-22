package com.coutodev.marmiMvp.Mapper;

import com.coutodev.marmiMvp.DTO.CriarRefeicaoDto;
import com.coutodev.marmiMvp.DTO.RefeicaoResponseDto;
import com.coutodev.marmiMvp.domain.Refeicoes.Refeicao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RefeicaoMapper {

  Refeicao toEntity (CriarRefeicaoDto dto);

  RefeicaoResponseDto toResponseDto (Refeicao entity);
}
