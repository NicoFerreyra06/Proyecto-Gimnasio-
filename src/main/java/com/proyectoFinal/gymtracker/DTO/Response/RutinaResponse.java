package com.proyectoFinal.gymtracker.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RutinaResponse {

    private Long id;
    private Long creadorId;
    private String nombre;
    private String tokenCompartir;
    private Double precio;
    private List<DiaRutinaResponse> diaRutinas;
}
