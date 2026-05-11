package com.proyectoFinal.gymtracker.DTO.Request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecordPersonalRequest {

    @NotNull
    private Long idUsuario;

    @NotNull
    private Long idEjercicio;

    private Double pesoMaximo;
    private LocalDate fechaLogro;

}
