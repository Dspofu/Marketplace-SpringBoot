package com.market.marketplace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.marketplace.models.IngredientesModel;
import com.market.marketplace.repository.IngredientesRepository;

@Service
public class IngredientesService {

    @Autowired
    private IngredientesRepository ingredientesRepository;

    public IngredientesModel cadastrar(IngredientesModel ingrediente) {
        if (ingredientesRepository.existsByIngredientesLancheIgnoreCase(ingrediente.getIngredientesLanche())) {
            throw new RuntimeException("Ingrediente já cadastrado");
        }
        return ingredientesRepository.save(ingrediente);
    }

    public List<IngredientesModel> listarTodos() {
        return ingredientesRepository.findAll();
    }

    public IngredientesModel buscarPorId(Long id) {
        return ingredientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));
    }

    public IngredientesModel editar(Long id, IngredientesModel ingredienteAtualizado) {
        IngredientesModel ingrediente = buscarPorId(id);
        ingrediente.setIngredientesLanche(ingredienteAtualizado.getIngredientesLanche());
        return ingredientesRepository.save(ingrediente);
    }

    public void deletar(Long id) {
        IngredientesModel ingrediente = buscarPorId(id);
        ingredientesRepository.delete(ingrediente);
    }
}