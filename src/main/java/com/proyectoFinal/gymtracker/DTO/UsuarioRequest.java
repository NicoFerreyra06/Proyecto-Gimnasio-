package com.proyectoFinal.gymtracker.DTO;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String username;
    private String email;
    private String password;
    private Double peso;
    private Double altura;
}
