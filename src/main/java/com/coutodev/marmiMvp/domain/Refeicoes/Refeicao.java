package com.coutodev.marmiMvp.domain.Refeicoes;

import com.coutodev.marmiMvp.domain.Parceiros.Parceiro;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "refeicoes")
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;

    private String descricao;

    private Double calorias;

    private Double proteinas;

    private Double gorduras;

    private BigDecimal preco;

    private Boolean ativo = true;
    @ManyToOne
    @JoinColumn(name = "parceiro_id")
    private Parceiro parceiro;
}
