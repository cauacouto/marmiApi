package com.coutodev.marmiMvp.domain.Usuarios;

import com.coutodev.marmiMvp.domain.Pedido.Pedido;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String email;

    private String senha;
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos = new ArrayList<>();
    // atualizar a migration que eu coloquei uma lista de pedidos

    public Usuario(UUID id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Usuario(){}

    public String getNome() {
        return nome;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
