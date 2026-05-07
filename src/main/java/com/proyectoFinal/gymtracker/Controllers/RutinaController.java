package com.proyectoFinal.gymtracker.Controllers;

import com.proyectoFinal.gymtracker.DTO.Request.RutinaRequest;
import com.proyectoFinal.gymtracker.DTO.Response.RutinaResponse;
import com.proyectoFinal.gymtracker.Modelo.Rutina;
import com.proyectoFinal.gymtracker.Services.RutinaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rutinas")
@RequiredArgsConstructor
public class RutinaController {

    private final RutinaService rutinaService;

    @PostMapping
    public ResponseEntity<RutinaResponse> createRutina(@Valid @RequestBody RutinaRequest rutinaRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rutinaService.createRutina(rutinaRequest));
    }

    @GetMapping("/{idRutina}")
    public ResponseEntity<RutinaResponse> getRutinaById(@PathVariable Long idRutina){
        return ResponseEntity.status(HttpStatus.OK).body(rutinaService.getRutinaById(idRutina));
    }

    @DeleteMapping("/{idRutina}")
    public ResponseEntity<Void> deleteRutinaById(@PathVariable Long idRutina){
        rutinaService.deleteRutina(idRutina);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
