/*package com.market.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.market.marketplace.dto.LoginResponseDTO;
import com.market.marketplace.dto.UsuarioResponseDTO;
import com.market.marketplace.models.UsuariosModel;
import com.market.marketplace.services.UsuarioService;
import com.market.marketplace.util.JwtUtil;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody UsuariosModel usuario) {
        UsuariosModel novoUsuario = usuarioService.cadastrar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(novoUsuario));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody UsuariosModel usuario) {
        UsuariosModel usuarioLogado = usuarioService.login(
                usuario.getNomeUsuario(),
                usuario.getSenhaUsuario());

        String token = jwtUtil.gerarToken(
                usuarioLogado.getNomeUsuario(),
                usuarioLogado.getId());

        LoginResponseDTO response = new LoginResponseDTO();
        response.setToken(token);
        response.setIdUsuario(usuarioLogado.getId());
        response.setNomeUsuario(usuarioLogado.getNomeUsuario());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/redefinir/{id}")
    public ResponseEntity<UsuarioResponseDTO> redefinirSenha(
            @PathVariable Long id,
            @RequestBody UsuariosModel usuario) {
        UsuariosModel usuarioAtualizado = usuarioService.redefinirSenha(id, usuario);
        return ResponseEntity.ok(toResponseDTO(usuarioAtualizado));
    }

    private UsuarioResponseDTO toResponseDTO(UsuariosModel model) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(model.getId());
        dto.setNomeUsuario(model.getNomeUsuario());
        return dto;
    }
}
    */

package com.market.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.market.marketplace.dto.LoginResponseDTO;
import com.market.marketplace.dto.UsuarioResponseDTO;
import com.market.marketplace.models.UsuariosModel;
import com.market.marketplace.services.UsuarioService;
import com.market.marketplace.util.JwtUtil;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody UsuariosModel usuario) {
        UsuariosModel novoUsuario = usuarioService.cadastrar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(novoUsuario));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody UsuariosModel usuario) {
        UsuariosModel usuarioLogado = usuarioService.login(
                usuario.getNomeUsuario(),
                usuario.getSenhaUsuario()
        );

        String token = jwtUtil.gerarToken(
                usuarioLogado.getNomeUsuario(),
                usuarioLogado.getId()
        );

        LoginResponseDTO response = new LoginResponseDTO();
        response.setToken(token);
        response.setIdUsuario(usuarioLogado.getId());
        response.setNomeUsuario(usuarioLogado.getNomeUsuario());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/redefinir/{id}")
    public ResponseEntity<UsuarioResponseDTO> redefinirSenha(
            @PathVariable Long id,
            @RequestBody UsuariosModel usuario) {
        UsuariosModel usuarioAtualizado = usuarioService.redefinirSenha(id, usuario);
        return ResponseEntity.ok(toResponseDTO(usuarioAtualizado));
    }

    private UsuarioResponseDTO toResponseDTO(UsuariosModel model) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(model.getId());
        dto.setNomeUsuario(model.getNomeUsuario());
        return dto;
    }
}