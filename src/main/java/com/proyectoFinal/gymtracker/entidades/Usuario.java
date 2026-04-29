package com.proyectoFinal.gymtracker.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    private Double peso;
    private Double altura;

    @Column(unique = true)
    private String codigoAmigo; // UUID para compartir

    @ManyToMany
    @JoinTable(
        name = "amigos",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "amigo_id")
    )
    private List<Usuario> amigos;

    @ManyToOne
    @JoinColumn(name = "rutina_activa_id")
    private Rutina rutinaActiva;

    // Relación para que un usuario pueda tener un entrenador
    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Usuario entrenador;

    // Un entrenador puede tener muchos clientes
    @OneToMany(mappedBy = "entrenador")
    private List<Usuario> clientes;

    // La racha se podría calcular dinámicamente con EntrenamientoLog,
    // pero guardamos un caché de la racha actual para mostrarla rápido.
    private Integer rachaActualDias;
    private Integer rachaMaximaDias;

    public Double getImc() {
        if (peso != null && altura != null && altura > 0) {
            return peso / (altura * altura);
        }
        return null;
    }
}
