package com.proyectoFinal.gymtracker.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaRutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayOfWeek diaDeLaSemana;

    @ManyToOne
    @JoinColumn(name = "rutina_id", nullable = false)
    @JsonIgnore
    private Rutina rutina;

    @OneToMany(mappedBy = "dia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EjercicioRutina> ejercicios;
}
