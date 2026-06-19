package com.market.marketplace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.marketplace.models.UsuariosModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuariosModel, Long> {

  /* As alterações feitas aqui no repository é pra deixar compativel com a mudança dos models */
  Optional<UsuariosModel> findByNomeUsuario(String nomeUsuario);
  
  boolean existsByNomeUsuario(String nomeUsuario);
}