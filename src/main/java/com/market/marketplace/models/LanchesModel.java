package com.market.marketplace.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "Lanches")
@Data
@AllArgsConstructor
public class LanchesModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private String foto; 

  private Double preco;

  @ManyToOne
  @JoinColumn(name = "usuario_id", nullable = false)
  private UsuariosModel usuario;

  @ManyToMany
  @JoinTable(
    name = "lanche_ingrediente",
    joinColumns = @JoinColumn(name = "lanche_id"),
    inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
  )
  private List<IngredientesModel> ingredientes; 
}