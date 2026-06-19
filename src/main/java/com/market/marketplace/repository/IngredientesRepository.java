package com.market.marketplace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.marketplace.models.IngredientesModel;

@Repository
public interface IngredientesRepository extends JpaRepository<IngredientesModel, Long> {

  /* As alterações feitas aqui no repository é pra deixar compativel com a mudança dos models */
  Optional<IngredientesModel> findByIngredientesLancheIgnoreCase(String ingredientesLanche);
  
  boolean existsByIngredientesLancheIgnoreCase(String ingredientesLanche);
}