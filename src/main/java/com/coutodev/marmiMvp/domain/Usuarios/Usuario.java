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
   

    public Usuario( UsuarioDto dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.senha = dto.senha();
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
