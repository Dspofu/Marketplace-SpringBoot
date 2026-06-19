package com.market.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.market.marketplace.models.UsuariosModel;
import com.market.marketplace.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuariosModel> cadastrar(@RequestBody UsuariosModel usuario) {
        UsuariosModel novoUsuario = usuarioService.cadastrar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuariosModel> login(@RequestBody UsuariosModel usuario) {
        UsuariosModel usuarioLogado = usuarioService.login(
                usuario.getNomeUsuario(), 
                usuario.getSenhaUsuario()
        );
        return ResponseEntity.ok(usuarioLogado);
    }

    @PutMapping("/redefinir/{id}")
    public ResponseEntity<UsuariosModel> redefinirSenha(
            @PathVariable Long id, 
            @RequestBody UsuariosModel usuario) {
        UsuariosModel usuarioAtualizado = usuarioService.redefinirSenha(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }
}