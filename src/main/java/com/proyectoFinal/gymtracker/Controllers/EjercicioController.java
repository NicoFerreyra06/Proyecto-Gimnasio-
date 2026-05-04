package com.proyectoFinal.gymtracker.Controllers;

<<<<<<< HEAD

=======
import com.proyectoFinal.gymtracker.DTO.EjercicioRequest;
>>>>>>> 135b659 (ejercicio dto,controller y service)
import com.proyectoFinal.gymtracker.Modelo.Ejercicio;
import com.proyectoFinal.gymtracker.Services.EjercicioService;
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

<<<<<<< HEAD
    @GetMapping
    public ResponseEntity<List<Ejercicio>> getAll() {
        return ResponseEntity.ok(ejercicioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ejercicio> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ejercicioService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Ejercicio> crear(@RequestBody Ejercicio ejercicio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ejercicioService.crearEjercicio(ejercicio));
    }

    //falta terminar
=======
    @PostMapping
    public ResponseEntity<Ejercicio> addEjercicio(@RequestBody EjercicioRequest ejercicio){
        return ResponseEntity.status(HttpStatus.CREATED).body(ejercicioService.addEjercicio(ejercicio));
    }

    @PostMapping("/lote")
    public ResponseEntity<List<Ejercicio>> addEjercicios(@RequestBody List<EjercicioRequest> ejercicios){
        return ResponseEntity.status(HttpStatus.CREATED).body(ejercicioService.addEjercicios(ejercicios));
    }

    @DeleteMapping("/{idMusculo}")
    public ResponseEntity<Void> deleteEjercicio(@PathVariable Long idMusculo){
        ejercicioService.deleteEjercicio(idMusculo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idMusuclo}")
    public ResponseEntity<Ejercicio> getEjercicio(@PathVariable Long idEjercicio){
        return ResponseEntity.ok(ejercicioService.getEjercicioById(idEjercicio));
    }

    @GetMapping
    public ResponseEntity<List<Ejercicio>> getAllEjercicio(){
        return ResponseEntity.status(HttpStatus.OK).body(ejercicioService.getEjercicios());
    }
>>>>>>> 135b659 (ejercicio dto,controller y service)
}
