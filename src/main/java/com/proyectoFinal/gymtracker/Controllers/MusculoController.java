package com.proyectoFinal.gymtracker.Controllers;

import com.proyectoFinal.gymtracker.Modelo.Musculo;
import com.proyectoFinal.gymtracker.Services.MusculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musculos")
@RequiredArgsConstructor
public class MusculoController {

    private final MusculoService musculoService;

    @PostMapping
    public ResponseEntity<List<Musculo>> addMusculos(@RequestBody List<Musculo> musculos){
        return ResponseEntity.status(HttpStatus.CREATED).body(musculoService.addMusculos(musculos));
    }

    @DeleteMapping("/{idMusculos}")
    public ResponseEntity<Void> deleteMusculos(@PathVariable Long idMusculos){
        musculoService.deleteMusculos(idMusculos);
        return ResponseEntity.noContent().build();
    }
}
