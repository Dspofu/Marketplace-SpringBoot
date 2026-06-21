package com.market.marketplace.dto;

import com.market.marketplace.models.IngredientesModel;
import lombok.Data;

@Data
public class LancheResponseDTO {
    private Long id;
    private String nomeLanche;
    private String fotoLanche;
    private Double precoLanche;
    private UsuarioResponseDTO usuario;
    private IngredientesModel ingrediente;
}