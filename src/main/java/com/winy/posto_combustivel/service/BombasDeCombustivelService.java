package com.winy.posto_combustivel.service;

import com.winy.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.winy.posto_combustivel.infrastructure.repositories.BombasDeCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Serviço de bomba de combustível.

@Service
@RequiredArgsConstructor
public class BombasDeCombustivelService {

    private final BombasDeCombustivelRepository bombasDeCombustivelRepository;

    public void criar(BombasDeCombustivel bombasDeCombustivel) {
        bombasDeCombustivelRepository.save(bombasDeCombustivel);
    }

    public BombasDeCombustivel buscarBombaDeCombustivelPorId(Integer id) {
        return bombasDeCombustivelRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Bomba de combustivel não encontrada pelo id" + id));
    }

    public List<BombasDeCombustivel> buscarBombaDeCombustivel() {
        return bombasDeCombustivelRepository.findAll();
    }

    @Transactional
    public void deletarBombaCombustivel(Integer id) {
        bombasDeCombustivelRepository.deleteById(id);
    }

    public void alterarBombaDecombustivel(Integer id, BombasDeCombustivel bombasDeCombustivel) {
        BombasDeCombustivel bomba = buscarBombaDeCombustivelPorId(id);
        bombasDeCombustivel.setId(bomba.getId());

        bombasDeCombustivelRepository.save(bombasDeCombustivel);
    }

}
