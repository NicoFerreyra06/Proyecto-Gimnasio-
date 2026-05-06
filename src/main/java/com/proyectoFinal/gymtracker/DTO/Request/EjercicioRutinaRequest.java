package com.proyectoFinal.gymtracker.DTO.Request;

import com.proyectoFinal.gymtracker.Services.RutinaService;
import lombok.Data;

@Data
public class EjercicioRutinaRequest {
    private Long ejercicioId;
    private int series;
    private int repeticiones;
}
