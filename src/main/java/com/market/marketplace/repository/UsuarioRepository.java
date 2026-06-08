package com.market.marketplace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.marketplace.models.UsuariosModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuariosModel, Long> {

  Optional<UsuariosModel> findByUsuario(String usuario);
  
  boolean existsByUsuario(String usuario);
}