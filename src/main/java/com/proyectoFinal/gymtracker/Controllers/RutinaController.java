package com.proyectoFinal.gymtracker.Controllers;

import com.proyectoFinal.gymtracker.DTO.Request.RutinaRequest;
import com.proyectoFinal.gymtracker.DTO.Response.DiaRutinaResponse;
import com.proyectoFinal.gymtracker.DTO.Response.RutinaResponse;
import com.proyectoFinal.gymtracker.DTO.Response.UsuarioResponse;
import com.proyectoFinal.gymtracker.Services.RutinaService;
import com.proyectoFinal.gymtracker.Services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rutinas")
@RequiredArgsConstructor
public class RutinaController {

    private final RutinaService rutinaService;
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<RutinaResponse> createRutina(@Valid @RequestBody RutinaRequest rutinaRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rutinaService.createRutina(rutinaRequest));
    }

    @GetMapping("/{idRutina}")
    public ResponseEntity<RutinaResponse> getRutinaById(@PathVariable Long idRutina){
        return ResponseEntity.status(HttpStatus.OK).body(rutinaService.getRutinaById(idRutina));
    }

    @GetMapping
    public ResponseEntity<List<RutinaResponse>> getAllRutinas(){
        return ResponseEntity.status(HttpStatus.OK).body(rutinaService.getAllRutinas());
    }

    @DeleteMapping("/{idRutina}")
    public ResponseEntity<Void> deleteRutinaById(@PathVariable Long idRutina){
        rutinaService.deleteRutina(idRutina);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{idUsuario}/rutina-activa/{idRutina}")
    public ResponseEntity<UsuarioResponse> activarRutina(@PathVariable Long idUsuario, @PathVariable Long idRutina) {
        return ResponseEntity.ok(usuarioService.activarRutina(idUsuario, idRutina));
    }

    @GetMapping("/usuario/{idUsuario}/hoy")
    public ResponseEntity<DiaRutinaResponse> getDiaActual(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(rutinaService.getDiaRutinaActual(idUsuario));
    }

}
