package com.market.marketplace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.marketplace.models.IngredientesModel;
import com.market.marketplace.models.LanchesModel;
import com.market.marketplace.models.UsuariosModel;
import com.market.marketplace.repository.IngredientesRepository;
import com.market.marketplace.repository.LanchesRepository;
import com.market.marketplace.repository.UsuarioRepository;

@Service
public class LanchesService {

    @Autowired
    private LanchesRepository lanchesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IngredientesRepository ingredientesRepository;

    public LanchesModel cadastrar(LanchesModel lanche, Long idUsuario, List<Long> idIngredientes) {
        UsuariosModel usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<IngredientesModel> ingredientes = ingredientesRepository.findAllById(idIngredientes);

        lanche.setUsuario(usuario);
        lanche.setIngredientes(ingredientes);

        return lanchesRepository.save(lanche);
    }

    public List<LanchesModel> listarTodos() {
        return lanchesRepository.findAll();
    }

    public LanchesModel buscarPorId(Long id) {
        return lanchesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lanche não encontrado"));
    }

    public LanchesModel editar(Long id, LanchesModel lancheAtualizado, Long idUsuario, List<Long> idIngredientes) {
        LanchesModel lanche = buscarPorId(id);

        UsuariosModel usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<IngredientesModel> ingredientes = ingredientesRepository.findAllById(idIngredientes);

        lanche.setNomeLanche(lancheAtualizado.getNomeLanche());
        lanche.setFotoLanche(lancheAtualizado.getFotoLanche());
        lanche.setPrecoLanche(lancheAtualizado.getPrecoLanche());
        lanche.setUsuario(usuario);
        lanche.setIngredientes(ingredientes);

        return lanchesRepository.save(lanche);
    }

    public void deletar(Long id) {
        LanchesModel lanche = buscarPorId(id);
        lanchesRepository.delete(lanche);
    }
}