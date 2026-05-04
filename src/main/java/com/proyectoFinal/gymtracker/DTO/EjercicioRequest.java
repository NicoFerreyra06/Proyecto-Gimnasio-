package com.proyectoFinal.gymtracker.DTO;

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
    private String nombre;
    private String descripcion;
    private List<Long> musculoPrincipalId;
    private List<Long> musculoSecundarioId;
}
