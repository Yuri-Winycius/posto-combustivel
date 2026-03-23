package com.winy.posto_combustivel.controller;

import com.winy.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.winy.posto_combustivel.service.BombasDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controle de requisisções de bombas de combustivel.

@RestController
@RequiredArgsConstructor
@RequestMapping("/bombasDeCombustivel")
public class BombasDeCombustivelController {

    private final BombasDeCombustivelService bombasDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody BombasDeCombustivel bombasDeCombustivel) {
        bombasDeCombustivelService.criar(bombasDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<BombasDeCombustivel>> buscarBombasDeCombustivel() {
        return ResponseEntity.ok(bombasDeCombustivelService.buscarBombaDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombasDeCombustivel> buscarBombasDeCombustivelPorId(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(bombasDeCombustivelService.buscarBombaDeCombustivelPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBombasDeCombustivelPorId(@PathVariable(name = "id") Integer id) {
        bombasDeCombustivelService.deletarBombaCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterarBombaDeCombustivel(@RequestParam(name = "id") Integer id,
                                                         @RequestBody BombasDeCombustivel bombasDeCombustivel) {
        bombasDeCombustivelService.alterarBombaDecombustivel(id, bombasDeCombustivel);
        return ResponseEntity.ok().build();
    }

}
