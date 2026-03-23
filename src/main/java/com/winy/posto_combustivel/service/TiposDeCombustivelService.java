package com.winy.posto_combustivel.service;

import com.winy.posto_combustivel.infrastructure.entities.TiposDeCombustivel;
import com.winy.posto_combustivel.infrastructure.repositories.TiposDeCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Serviço de tipos de combustível.

@Service
@RequiredArgsConstructor
public class TiposDeCombustivelService {

    private final TiposDeCombustivelRepository tiposDeCombustiveisRepository;

    public void criar(TiposDeCombustivel tiposDeCombustivel) {
        tiposDeCombustiveisRepository.save(tiposDeCombustivel);
    }

    public TiposDeCombustivel buscarTiposDeCombustivelPorId(Integer id) {
        return tiposDeCombustiveisRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Tipo de combustivel não encontrada pelo id" + id));
    }

    public List<TiposDeCombustivel> buscarTiposDeCombustivel() {
        return tiposDeCombustiveisRepository.findAll();
    }

    @Transactional
    public void deletarTipoCombustivel(Integer id) {
        tiposDeCombustiveisRepository.deleteById(id);
    }

    public void alterarTipoDecombustivel(Integer id, TiposDeCombustivel TiposDeCombustivel) {
        TiposDeCombustivel tipo = buscarTiposDeCombustivelPorId(id);
        TiposDeCombustivel.setId(tipo.getId());

        tiposDeCombustiveisRepository.save(TiposDeCombustivel);
    }

}
