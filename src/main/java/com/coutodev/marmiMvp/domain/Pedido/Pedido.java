package com.coutodev.marmiMvp.domain.Pedido;

import com.coutodev.marmiMvp.domain.ItemPedio.ItemPedido;
import com.coutodev.marmiMvp.domain.Usuarios.Usuario;
import com.coutodev.marmiMvp.enums.StatusPedido;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL , orphanRemoval = true)
    private List<ItemPedido> itemPedidos = new ArrayList<>();

    private StatusPedido statusPedido;

    private BigDecimal valorTotal;

    private LocalDateTime dataCriacao;

    // criar migration
}
