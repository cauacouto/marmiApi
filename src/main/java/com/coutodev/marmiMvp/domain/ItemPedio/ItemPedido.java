package com.coutodev.marmiMvp.domain.ItemPedio;

import com.coutodev.marmiMvp.domain.Pedido.Pedido;
import com.coutodev.marmiMvp.domain.Refeicoes.Refeicao;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "itemns")
public class ItemPedido {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

  private Integer quantidade;

@ManyToOne
@JoinColumn(name = "refeicao_id")
private Refeicao refeicao;

private Boolean precoUnitario;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private BigDecimal subTotal;

    // criar migration
}
