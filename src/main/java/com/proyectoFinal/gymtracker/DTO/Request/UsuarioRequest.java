package com.proyectoFinal.gymtracker.DTO.Request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UsuarioRequest {
    @NotBlank(message = "Debe indicar su username")
    private String username;
    @Email
    @NotBlank(message = "Debe indicar su email")
    private String email;
    @NotBlank @Size(min = 3, max = 30, message = "La contraseña debe tener entre 3 y 30 caracteres")
    private String password;
    @NotNull @Min(20)
    private Double peso;
    @NotNull @Min(0)
    private Double altura;
}
