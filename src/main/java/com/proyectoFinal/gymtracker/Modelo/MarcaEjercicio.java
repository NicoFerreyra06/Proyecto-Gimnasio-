package com.proyectoFinal.gymtracker.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarcaEjercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entrenamiento_log_id", nullable = false)
    private EntrenamientoLog entrenamientoLog;

    @ManyToOne
    @JoinColumn(name = "ejercicio_rutina_id", nullable = false)
    private EjercicioRutina ejercicioRutina;

    private Double pesoLevantado;
    private Integer repeticionesLogradas;
}
