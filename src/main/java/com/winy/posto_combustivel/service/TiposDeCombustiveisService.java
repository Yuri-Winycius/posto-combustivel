package com.winy.posto_combustivel.service;

import com.winy.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.winy.posto_combustivel.infrastructure.entities.TiposDeCombustivel;
import com.winy.posto_combustivel.infrastructure.repositories.TiposDeCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiposDeCombustiveisService {

    private final TiposDeCombustivelRepository tiposDeCombustiveisRepository;

    private void criar(TiposDeCombustivel tiposDeCombustivel) {
        tiposDeCombustiveisRepository.save(tiposDeCombustivel);
    }

    private TiposDeCombustivel buscarTiposDeCombustivelPorId(Integer id) {
        return tiposDeCombustiveisRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Tipo de combustivel não encontrada pelo id" + id));
    }

    private List<TiposDeCombustivel> buscarTiposDeCombustivel() {
        return tiposDeCombustiveisRepository.findAll();
    }

    @Transactional
    private void deletarTipoCombustivel(Integer id) {
        tiposDeCombustiveisRepository.deleteById(id);
    }

    private void alterarTipoDecombustivel(Integer id, TiposDeCombustivel TiposDeCombustivel) {
        TiposDeCombustivel tipo = buscarTiposDeCombustivelPorId(id);
        TiposDeCombustivel.setId(tipo.getId());

        tiposDeCombustiveisRepository.save(TiposDeCombustivel);
    }

}
