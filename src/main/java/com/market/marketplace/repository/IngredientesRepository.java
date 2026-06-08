package com.market.marketplace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.marketplace.models.IngredientesModel;

@Repository
public interface IngredientesRepository extends JpaRepository<IngredientesModel, Long> {

  Optional<IngredientesModel> findByNomeIgnoreCase(String nome);
  
  boolean existsByNomeIgnoreCase(String nome);
}