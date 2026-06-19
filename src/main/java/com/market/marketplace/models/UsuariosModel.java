package com.market.marketplace.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/* O JPA exije construtores sem argumento para os proxies, então é uma boa pratica ter as 2 importações ao utilizar o JPA */
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long id;

  /* Nomes alterados para garantir consistencia com o objeto json e manter a consistencia com a api antiga */
  private String nomeUsuario;

  private String senhaUsuario;
}