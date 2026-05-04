package com.proyectoFinal.gymtracker.Services;

<<<<<<< HEAD
import com.proyectoFinal.gymtracker.Modelo.Ejercicio;
import com.proyectoFinal.gymtracker.Repositories.EjercicioRepository;
=======
import com.proyectoFinal.gymtracker.DTO.EjercicioRequest;
import com.proyectoFinal.gymtracker.Modelo.Ejercicio;
import com.proyectoFinal.gymtracker.Repositories.EjercicioRepository;
import com.proyectoFinal.gymtracker.Repositories.MusculoRepository;
>>>>>>> 135b659 (ejercicio dto,controller y service)
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EjercicioService {

<<<<<<< HEAD
private final EjercicioRepository ejercicioRepository;

    public Ejercicio crearEjercicio(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    public List<Ejercicio> getAll() {
        return ejercicioRepository.findAll();
    }

    public Ejercicio getById(Long id) {
        return ejercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));
    }





=======
    private final EjercicioRepository ejercicioRepository;
    private final MusculoRepository musculoRepository;

    public Ejercicio addEjercicio(EjercicioRequest ejercicioRequest) {
        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setNombre(ejercicioRequest.getNombre());
        ejercicio.setDescripcion(ejercicioRequest.getDescripcion());
        ejercicio.setMusculosPrincipales(
                musculoRepository.findAllById(ejercicioRequest.getMusculoPrincipalId())
        );
        ejercicio.setMusculosSecundarios(
                musculoRepository.findAllById(ejercicioRequest.getMusculoSecundarioId())
        );
        return ejercicioRepository.save(ejercicio);
    }

    public List<Ejercicio> addEjercicios(List<EjercicioRequest> ejerciciosRequest) {
        List<Ejercicio> ejercicios = ejerciciosRequest.stream()
                .map(request -> Ejercicio.builder()
                        .nombre(request.getNombre())
                        .descripcion(request.getDescripcion())
                        .musculosPrincipales(musculoRepository.findAllById(request.getMusculoPrincipalId()))
                        .musculosSecundarios(musculoRepository.findAllById(request.getMusculoSecundarioId()))
                        .build()
                ).toList();
        return ejercicioRepository.saveAll(ejercicios);
    }

    public void deleteEjercicio(Long idEjercicio) {ejercicioRepository.deleteById(idEjercicio);}

    public Ejercicio getEjercicioById(Long idEjercicio) {
        return ejercicioRepository.findById(idEjercicio)
                .orElseThrow(()-> new RuntimeException("Ejercicio no encontrado"));
    }

    public List<Ejercicio> getEjercicios() {return ejercicioRepository.findAll();}
>>>>>>> 135b659 (ejercicio dto,controller y service)
}
