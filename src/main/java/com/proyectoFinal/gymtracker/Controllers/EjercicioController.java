package com.proyectoFinal.gymtracker.Controllers;


import com.proyectoFinal.gymtracker.DTO.Request.EjercicioRequest;
import com.proyectoFinal.gymtracker.DTO.Response.EjercicioResponse;
import com.proyectoFinal.gymtracker.Modelo.Ejercicio;
import com.proyectoFinal.gymtracker.Services.EjercicioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejercicios")
@RequiredArgsConstructor
public class EjercicioController {

    private final EjercicioService ejercicioService;
    @PostMapping
    public ResponseEntity<EjercicioResponse> addEjercicio(@Valid @RequestBody EjercicioRequest ejercicio){
        return ResponseEntity.status(HttpStatus.CREATED).body(ejercicioService.addEjercicio(ejercicio));
    }

    @PostMapping("/lote")
    public ResponseEntity<List<EjercicioResponse>> addEjercicios(@Valid @RequestBody List<EjercicioRequest> ejercicios){
        return ResponseEntity.status(HttpStatus.CREATED).body(ejercicioService.addEjercicios(ejercicios));
    }

    @DeleteMapping("/{idEjercicio}")
    public ResponseEntity<Void> deleteEjercicio(@PathVariable Long idEjercicio) {
        ejercicioService.deleteEjercicio(idEjercicio);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idEjercicio}")
    public ResponseEntity<Ejercicio> getEjercicio(@PathVariable Long idEjercicio) {
        return ResponseEntity.ok(ejercicioService.getById(idEjercicio));
    }

    @GetMapping
    public ResponseEntity<List<Ejercicio>> getAllEjercicio(){
        return ResponseEntity.status(HttpStatus.OK).body(ejercicioService.getAll());
    }

    //buscar por x musculo, sea el principal o con que exista en el ejercicio suficiente

    @GetMapping("/porMusculo/{musculoId}")
    public ResponseEntity<List<Ejercicio>> getByMusculo(@PathVariable Long musculoId) {
        return ResponseEntity.ok(ejercicioService.getByMusculo(musculoId));
    }

    @GetMapping("/porMusculoPrincipal/{musculoId}")
    public ResponseEntity<List<Ejercicio>> getByMusculoPrincipal(@PathVariable Long musculoId) {
        return ResponseEntity.ok(ejercicioService.getByMusculoPrincipal(musculoId));
    }


}
