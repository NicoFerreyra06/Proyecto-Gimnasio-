package com.proyectoFinal.gymtracker.DTO.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @Positive
    private Double pesoMaximo;

    private LocalDate fechaLogro;

}
