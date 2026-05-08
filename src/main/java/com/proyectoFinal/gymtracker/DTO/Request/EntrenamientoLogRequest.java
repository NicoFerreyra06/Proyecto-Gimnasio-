package com.proyectoFinal.gymtracker.DTO.Request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntrenamientoLogRequest {

    @NotNull(message = "Debe indicar el id del usuario")
    private Long idUsuario;

    @NotNull(message = "Debe indicar la rutina que siguio")
    private Long idRutina;
    private List<MarcaEjercicioRequest> marcasEjercicio;
}
