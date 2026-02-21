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

private BigDecimal precoUnitario;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private BigDecimal subTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
}
