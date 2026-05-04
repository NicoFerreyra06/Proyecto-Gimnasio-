package com.proyectoFinal.gymtracker.Services;

import com.proyectoFinal.gymtracker.DTO.EjercicioRequest;
import com.proyectoFinal.gymtracker.Modelo.Ejercicio;
import com.proyectoFinal.gymtracker.Repositories.EjercicioRepository;
import com.proyectoFinal.gymtracker.Repositories.MusculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EjercicioService {

    private final EjercicioRepository ejercicioRepository;
    private final MusculoRepository musculoRepository;

    public Ejercicio addEjercicio(EjercicioRequest request) {
        Ejercicio ejercicio = Ejercicio.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .musculosPrincipales(musculoRepository.findAllById(request.getMusculoPrincipalId()))
                .musculosSecundarios(musculoRepository.findAllById(request.getMusculoSecundarioId()))
                .build();
        return ejercicioRepository.save(ejercicio);
    }

    public List<Ejercicio> addEjercicios(List<EjercicioRequest> requests) {
        List<Ejercicio> ejercicios = requests.stream()
                .map(request -> Ejercicio.builder()
                        .nombre(request.getNombre())
                        .descripcion(request.getDescripcion())
                        .musculosPrincipales(musculoRepository.findAllById(request.getMusculoPrincipalId()))
                        .musculosSecundarios(musculoRepository.findAllById(request.getMusculoSecundarioId()))
                        .build()
                ).toList();
        return ejercicioRepository.saveAll(ejercicios);
    }

    public Ejercicio getById(Long id) {
        return ejercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));
    }

    public List<Ejercicio> getAll() {
        return ejercicioRepository.findAll();
    }

    public void deleteEjercicio(Long id) {
        ejercicioRepository.deleteById(id);
    }


    //del repo
    public List<Ejercicio> getByMusculo(Long musculoId) {
        return ejercicioRepository.findByMusculo(musculoId);
    }

    public List<Ejercicio> getByMusculoPrincipal(Long musculoId) {
        return ejercicioRepository.findByMusculoPrincipal(musculoId);
    }

}