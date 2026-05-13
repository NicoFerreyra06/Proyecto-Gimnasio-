package com.proyectoFinal.gymtracker.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.List;

@Data
public class RutinaRequest {

    @NotBlank(message = "El nombre de la rutina es obligatorio")
    private String nombre;
    @PositiveOrZero
    private Double precio;
    @NotNull(message = "El id del creador es obligatorio")
    private Long creadorId;
    private List<DiaRutinaRequest> dias;
}
