package com.market.marketplace.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.market.marketplace.models.IngredientesModel;
import com.market.marketplace.services.IngredientesService;

@RestController
@RequestMapping("/api/usuarios/ingredientes")
public class IngredientesController {

    @Autowired
    private IngredientesService ingredientesService;

    @PostMapping
    public ResponseEntity<IngredientesModel> cadastrar(@RequestBody IngredientesModel ingrediente) {
        IngredientesModel novoIngrediente = ingredientesService.cadastrar(ingrediente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoIngrediente);
    }

    @GetMapping
    public ResponseEntity<List<IngredientesModel>> listarTodos() {
        return ResponseEntity.ok(ingredientesService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientesModel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ingredientesService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientesModel> editar(
            @PathVariable Long id, 
            @RequestBody IngredientesModel ingrediente) {
        return ResponseEntity.ok(ingredientesService.editar(id, ingrediente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ingredientesService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}