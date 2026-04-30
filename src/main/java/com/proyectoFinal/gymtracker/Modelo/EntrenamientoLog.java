package com.proyectoFinal.gymtracker.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntrenamientoLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "rutina_ejecutada_id")
    private Rutina rutinaEjecutada;

    @OneToMany(mappedBy = "entrenamientoLog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MarcaEjercicio> marcas;
}
