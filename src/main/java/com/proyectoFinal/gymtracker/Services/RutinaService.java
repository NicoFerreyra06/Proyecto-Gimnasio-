package com.proyectoFinal.gymtracker.Services;

import com.proyectoFinal.gymtracker.DTO.Request.RutinaRequest;
import com.proyectoFinal.gymtracker.Enum.Rol;
import com.proyectoFinal.gymtracker.Modelo.*;
import com.proyectoFinal.gymtracker.Repositories.EjercicioRepository;
import com.proyectoFinal.gymtracker.Repositories.RutinaRepository;
import com.proyectoFinal.gymtracker.Repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RutinaService {

    private final RutinaRepository rutinaRepository;
    private final UsuarioRepository usuarioRepository;
    private final EjercicioRepository ejercicioRepository;

    @Transactional
    public Rutina createRutina(RutinaRequest rutinaRequest) {
        Usuario creador = usuarioRepository.findById(rutinaRequest.getCreadorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        validarPrecioYrol(rutinaRequest, creador);

        Rutina rutina = Rutina.builder()
                .creador(creador)
                .nombre(rutinaRequest.getNombre())
                .tokenCompartir(UUID.randomUUID().toString())
                .precio(rutinaRequest.getPrecio()).build();

        if (rutinaRequest.getDias() != null) {
            List<DiaRutina> diaRutinas = rutinaRequest.getDias().stream()
                    .map(diaDto -> {
                        DiaRutina dia = DiaRutina.builder() // Cada diaRequest se transforma en la entidad DiaRutina
                                .diaDeLaSemana(diaDto.getDiaDeLaSemana())
                                .rutina(rutina).build();

                        if (diaDto.getEjercicios() != null) {
                            // Por cada dia recorremos todos los ejercicios
                            List<EjercicioRutina> ejercicioRutinas = diaDto.getEjercicios()
                                    .stream().map(ejDto -> {
                                        Ejercicio ejBase = ejercicioRepository.findById(ejDto.getEjercicioId())
                                                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));
                                        return EjercicioRutina.builder()
                                                .dia(dia)
                                                .ejercicio(ejBase)
                                                .series(ejDto.getSeries())
                                                .repeticiones(ejDto.getRepeticiones())
                                                .build();
                                    }).toList();
                            dia.setEjercicios(ejercicioRutinas);
                        }
                        return dia;
                    }).toList();
            rutina.setDias(diaRutinas);
        }
        return rutinaRepository.save(rutina);
    }

    public Rutina getRutinaById(Long idRutina) {
        return rutinaRepository.findById(idRutina)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));
    }

    public void deleteRutina(Long idRutina) {
        if (!rutinaRepository.existsById(idRutina)) {
            throw new RuntimeException("La rutina no existe");
        }

        try {
            rutinaRepository.deleteById(idRutina);

        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No se puede eliminar la rutina porque actualmente está asignada a un usuario o existe en un historial de entrenamiento.");
        }
    }

    private void validarPrecioYrol (RutinaRequest rutinaRequest, Usuario creador) {

        boolean tienePrecio = rutinaRequest.getPrecio() != null && rutinaRequest.getPrecio() > 0;
        boolean esEntrenador = creador.getRol().equals(Rol.ENTRENADOR);

        if (tienePrecio && !esEntrenador) {
            throw new RuntimeException("Solo los usuarios con rol ENTRENADOR pueden asignar un precio a las rutinas.");
        }
    }
}
