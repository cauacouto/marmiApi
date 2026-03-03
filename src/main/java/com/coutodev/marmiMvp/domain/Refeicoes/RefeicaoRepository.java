package com.coutodev.marmiMvp.domain.Refeicoes;

import com.coutodev.marmiMvp.enums.TipoCozinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RefeicaoRepository extends JpaRepository<Refeicao,Long> {


    List<Refeicao> findByParceiroId(UUID parceiroId);

 List<Refeicao>  findByParceiroTipoCozinha(TipoCozinha tipoCozinha);
}
