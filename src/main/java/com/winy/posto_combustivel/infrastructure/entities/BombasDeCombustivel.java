package com.winy.posto_combustivel.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

// Entitidade que virará tabela bombas_de_combustivel no banco de dados.

@Entity
@Table(name = "bombas_de_combustivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BombasDeCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "combustivel_id")
    private TiposDeCombustivel tiposDeCombustivel;

}
