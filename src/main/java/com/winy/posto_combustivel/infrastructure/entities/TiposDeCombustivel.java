package com.winy.posto_combustivel.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

// Entitidade que virará tabela tipo_de_combustivel no banco de dados.

@Entity
@Table(name = "tipos_de_combustivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TiposDeCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco_por_litro")
    private BigDecimal precoPorLitro;

}
