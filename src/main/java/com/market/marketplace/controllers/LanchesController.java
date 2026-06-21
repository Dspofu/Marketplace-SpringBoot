package com.market.marketplace.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.market.marketplace.dto.LancheRequestDTO;
import com.market.marketplace.dto.LancheResponseDTO;
import com.market.marketplace.dto.UsuarioResponseDTO;
import com.market.marketplace.models.LanchesModel;
import com.market.marketplace.services.LanchesService;

@RestController
@RequestMapping("/api/usuarios/lanches")
public class LanchesController {

    @Autowired
    private LanchesService lanchesService;

    @PostMapping
    public ResponseEntity<LancheResponseDTO> cadastrar(@RequestBody LancheRequestDTO dto) {
        LanchesModel lanche = new LanchesModel();
        lanche.setFotoLanche(dto.getFotoLanche());
        lanche.setNomeLanche(dto.getNomeLanche());
        lanche.setPrecoLanche(dto.getPrecoLanche());

        LanchesModel novoLanche = lanchesService.cadastrar(lanche, dto.getIdUsuario(), dto.getIdIngrediente());
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(novoLanche));
    }

    @GetMapping
    public ResponseEntity<List<LancheResponseDTO>> listarTodos() {
        List<LanchesModel> lanches = lanchesService.listarTodos();
        return ResponseEntity.ok(lanches.stream().map(this::toResponseDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LancheResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(toResponseDTO(lanchesService.buscarPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LancheResponseDTO> editar(
            @PathVariable Long id, 
            @RequestBody LancheRequestDTO dto) {
        LanchesModel lanche = new LanchesModel();
        lanche.setFotoLanche(dto.getFotoLanche());
        lanche.setNomeLanche(dto.getNomeLanche());
        lanche.setPrecoLanche(dto.getPrecoLanche());

        LanchesModel lancheAtualizado = lanchesService.editar(id, lanche, dto.getIdUsuario(), dto.getIdIngrediente());
        return ResponseEntity.ok(toResponseDTO(lancheAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        lanchesService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private LancheResponseDTO toResponseDTO(LanchesModel model) {
        LancheResponseDTO dto = new LancheResponseDTO();
        dto.setId(model.getId());
        dto.setNomeLanche(model.getNomeLanche());
        dto.setFotoLanche(model.getFotoLanche());
        dto.setPrecoLanche(model.getPrecoLanche());

        UsuarioResponseDTO usuarioDTO = new UsuarioResponseDTO();
        usuarioDTO.setId(model.getUsuario().getId());
        usuarioDTO.setNomeUsuario(model.getUsuario().getNomeUsuario());
        dto.setUsuario(usuarioDTO);

        dto.setIngrediente(model.getIngrediente());
        return dto;
    }
}