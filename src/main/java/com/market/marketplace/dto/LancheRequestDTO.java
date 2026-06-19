package com.market.marketplace.dto;

import java.util.List;
import lombok.Data;

@Data
public class LancheRequestDTO {
    private String fotoLanche;
    private String nomeLanche;
    private Double precoLanche;
    private Long idUsuario;
    private List<Long> idIngredientes;
}