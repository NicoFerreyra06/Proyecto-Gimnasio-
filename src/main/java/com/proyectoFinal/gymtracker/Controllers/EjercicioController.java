package com.proyectoFinal.gymtracker.Controllers;


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
}
