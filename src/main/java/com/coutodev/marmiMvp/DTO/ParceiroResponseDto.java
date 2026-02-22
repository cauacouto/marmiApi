package com.coutodev.marmiMvp.DTO;

public record ParceiroResponseDto(Long id,
                                  String nome,
                                  String email,
                                  String telefone,
                                  Boolean ativo) {
}
