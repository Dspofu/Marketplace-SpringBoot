package com.market.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.marketplace.models.LanchesModel;
import com.market.marketplace.models.UsuariosModel;

@Repository
public interface LanchesRepository extends JpaRepository<LanchesModel, Long> {

  List<LanchesModel> findByUsuario(UsuariosModel usuario);

  List<LanchesModel> findByUsuarioId(Long usuarioId);
}