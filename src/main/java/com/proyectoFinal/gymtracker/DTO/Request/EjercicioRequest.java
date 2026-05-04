package com.proyectoFinal.gymtracker.DTO.Request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EjercicioRequest {
    @NotBlank
    private String nombre;
    @Size(max = 100, message = "La descripción no puede superar los 100 caracteres")
    private String descripcion;
    @NotNull
    private List<Long> musculoPrincipalId;
    private List<Long> musculoSecundarioId;
}
