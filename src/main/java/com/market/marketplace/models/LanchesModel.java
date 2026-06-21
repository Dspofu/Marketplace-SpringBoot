/*package com.market.marketplace.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/* O JPA exije construtores sem argumento para os proxies, então é uma boa pratica ter as 2 importações ao utilizar o JPA 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "Lanches")
@Data


@AllArgsConstructor
@NoArgsConstructor
public class LanchesModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /* Nomes alterados para garantir consistencia com o objeto json e manter a consistencia com a api antiga 
  private String nomeLanche;

  private String fotoLanche; 

  private Double precoLanche;

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
*/
package com.market.marketplace.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Lanches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanchesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeLanche;
    private String fotoLanche; 
    private Double precoLanche;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuariosModel usuario;

    @ManyToOne
    @JoinColumn(name = "ingrediente_id", nullable = false)
    private IngredientesModel ingrediente;
}