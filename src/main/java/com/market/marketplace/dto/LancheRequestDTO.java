package com.market.marketplace.dto;

import lombok.Data;

@Data
public class LancheRequestDTO {
    private String fotoLanche;
    private String nomeLanche;
    private Double precoLanche;
    private Long idUsuario;
    private Long idIngrediente;
}