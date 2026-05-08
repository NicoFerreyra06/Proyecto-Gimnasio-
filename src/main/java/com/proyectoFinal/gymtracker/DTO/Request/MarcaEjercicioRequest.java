package com.proyectoFinal.gymtracker.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarcaEjercicioRequest {
    private Double pesoLevantado;
    private Integer repeticionesLogradas;
    private Long ejercicioRutinaId;
}
