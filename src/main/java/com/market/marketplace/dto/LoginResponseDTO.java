package com.market.marketplace.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String token;
    private Long idUsuario;
    private String nomeUsuario;
}