package com.winy.posto_combustivel.controller;

import com.winy.posto_combustivel.infrastructure.entities.TiposDeCombustivel;
import com.winy.posto_combustivel.service.TiposDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controle de requisisções de tipos de combustivel.

@RestController
@RequiredArgsConstructor
@RequestMapping("/tipoDeCombustivel")
public class TiposDeCombustivelController {

    private final TiposDeCombustivelService tiposDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody TiposDeCombustivel tiposDeCombustivel) {
        tiposDeCombustivelService.criar(tiposDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<TiposDeCombustivel>> buscarTiposDeCombustivel() {
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiposDeCombustivel> buscarTiposDeCombustivelPorId(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivelPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTiposDeCombustivelPorId(@PathVariable(name = "id") Integer id) {
        tiposDeCombustivelService.deletarTipoCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterarTipoDeCombustivel(@RequestParam(name = "id") Integer id,
                                                         @RequestBody TiposDeCombustivel tiposDeCombustivel) {
        tiposDeCombustivelService.alterarTipoDecombustivel(id, tiposDeCombustivel);
        return ResponseEntity.ok().build();
    }

}
