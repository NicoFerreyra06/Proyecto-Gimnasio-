package com.proyectoFinal.gymtracker.DTO.Request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UsuarioRequest {
    @NotBlank
    private String username;
    @Email
    @NotBlank
    private String email;
    @NotBlank @Size(min = 3, max = 30)
    private String password;
    @NotNull @Min(20)
    private Double peso;
    @NotNull @Min(0)
    private Double altura;
}
