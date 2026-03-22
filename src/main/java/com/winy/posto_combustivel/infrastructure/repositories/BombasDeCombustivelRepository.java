package com.winy.posto_combustivel.infrastructure.repositories;

import com.winy.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BombasDeCombustivelRepository extends JpaRepository<BombasDeCombustivel, Integer> {
}
