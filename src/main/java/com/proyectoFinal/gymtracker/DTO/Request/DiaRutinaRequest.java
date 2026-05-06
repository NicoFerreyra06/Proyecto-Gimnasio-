package com.proyectoFinal.gymtracker.DTO.Request;

import lombok.Data;

import java.time.DayOfWeek;
import java.util.List;

@Data
public class DiaRutinaRequest {
    private DayOfWeek diaDeLaSemana;
    private List<EjercicioRutinaRequest> ejercicios;
}
