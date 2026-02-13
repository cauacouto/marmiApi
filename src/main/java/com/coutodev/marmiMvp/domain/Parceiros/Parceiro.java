package com.coutodev.marmiMvp.domain.Parceiros;

import com.coutodev.marmiMvp.domain.Refeicoes.Refeicao;
import com.coutodev.marmiMvp.enums.TipoCozinha;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "parceiros")
public class Parceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private String nomeLoja;

    private String endereco;

    @Enumerated(EnumType.STRING)
    private TipoCozinha tipoCozinha;
    @OneToMany(mappedBy = "parceiro",cascade = CascadeType.ALL)
    private List<Refeicao> refeicoes = new ArrayList<>();
}
