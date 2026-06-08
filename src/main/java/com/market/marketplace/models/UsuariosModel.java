package com.market.marketplace.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Usuarios")
@Data
@AllArgsConstructor
public class UsuariosModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long id;

  private String usuario;

  private String senha;
}