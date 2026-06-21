/*package com.market.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.marketplace.models.UsuariosModel;
import com.market.marketplace.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuariosModel cadastrar(UsuariosModel usuario) {
        if (usuarioRepository.existsByNomeUsuario(usuario.getNomeUsuario())) {
            throw new RuntimeException("Usuário já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    public UsuariosModel login(String nomeUsuario, String senhaUsuario) {
        UsuariosModel usuario = usuarioRepository.findByNomeUsuario(nomeUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getSenhaUsuario().equals(senhaUsuario)) {
            throw new RuntimeException("Senha incorreta");
        }

        return usuario;
    }

    public UsuariosModel redefinirSenha(Long id, UsuariosModel usuarioAtualizado) {
        UsuariosModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getNomeUsuario().equals(usuarioAtualizado.getNomeUsuario())) {
            throw new RuntimeException("O nome de usuário não pode ser alterado");
        }

        usuario.setSenhaUsuario(usuarioAtualizado.getSenhaUsuario());
        return usuarioRepository.save(usuario);
    }
}
    */

package com.market.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.marketplace.models.UsuariosModel;
import com.market.marketplace.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public UsuariosModel cadastrar(UsuariosModel usuario) {
        if (usuarioRepository.existsByNomeUsuario(usuario.getNomeUsuario())) {
            throw new RuntimeException("Usuário já cadastrado");
        }
        
        // Garante que é um novo usuário (id null = novo registro)
        usuario.setId(null);
        
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public UsuariosModel login(String nomeUsuario, String senhaUsuario) {
        UsuariosModel usuario = usuarioRepository.findByNomeUsuario(nomeUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getSenhaUsuario().equals(senhaUsuario)) {
            throw new RuntimeException("Senha incorreta");
        }

        return usuario;
    }

    @Transactional
    public UsuariosModel redefinirSenha(Long id, UsuariosModel usuarioAtualizado) {
        UsuariosModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getNomeUsuario().equals(usuarioAtualizado.getNomeUsuario())) {
            throw new RuntimeException("O nome de usuário não pode ser alterado");
        }

        usuario.setSenhaUsuario(usuarioAtualizado.getSenhaUsuario());
        return usuarioRepository.save(usuario);
    }
}