package com.proyectoFinal.gymtracker.Controllers;

import com.proyectoFinal.gymtracker.DTO.Request.EntrenamientoLogRequest;
import com.proyectoFinal.gymtracker.DTO.Response.EntrenamientoLogResponse;
import com.proyectoFinal.gymtracker.Services.EntrenamientoLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrenamientos")
@RequiredArgsConstructor
public class EntrenamientoLogController {

    private final EntrenamientoLogService entrenamientoLogService;

    @PostMapping
    public ResponseEntity<EntrenamientoLogResponse> addEntrenamientoLog (@RequestBody EntrenamientoLogRequest entrenamientoLogRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(entrenamientoLogService.addEntrenamientoLog(entrenamientoLogRequest));
    }

    @GetMapping("/{idEntrenamiento}")
    public ResponseEntity<EntrenamientoLogResponse> getEntrenamientoLogById(@PathVariable Long idEntrenamiento){
        return ResponseEntity.status(HttpStatus.OK)
                .body(entrenamientoLogService.getEntrenamientoLogById(idEntrenamiento));
    }
}
