package com.market.marketplace.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.market.marketplace.dto.LancheRequestDTO;
import com.market.marketplace.models.LanchesModel;
import com.market.marketplace.services.LanchesService;

@RestController
@RequestMapping("/api/usuarios/lanches")
public class LanchesController {

    @Autowired
    private LanchesService lanchesService;

    @PostMapping
    public ResponseEntity<LanchesModel> cadastrar(@RequestBody LancheRequestDTO dto) {
        LanchesModel lanche = new LanchesModel();
        lanche.setFotoLanche(dto.getFotoLanche());
        lanche.setNomeLanche(dto.getNomeLanche());
        lanche.setPrecoLanche(dto.getPrecoLanche());

        LanchesModel novoLanche = lanchesService.cadastrar(lanche, dto.getIdUsuario(), dto.getIdIngredientes());
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLanche);
    }

    @GetMapping
    public ResponseEntity<List<LanchesModel>> listarTodos() {
        return ResponseEntity.ok(lanchesService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanchesModel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(lanchesService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanchesModel> editar(
            @PathVariable Long id, 
            @RequestBody LancheRequestDTO dto) {
        LanchesModel lanche = new LanchesModel();
        lanche.setFotoLanche(dto.getFotoLanche());
        lanche.setNomeLanche(dto.getNomeLanche());
        lanche.setPrecoLanche(dto.getPrecoLanche());

        LanchesModel lancheAtualizado = lanchesService.editar(id, lanche, dto.getIdUsuario(), dto.getIdIngredientes());
        return ResponseEntity.ok(lancheAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        lanchesService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}