package com.proyectoFinal.gymtracker.Controllers;

import com.proyectoFinal.gymtracker.DTO.Request.LoginRequest;
import com.proyectoFinal.gymtracker.DTO.Request.UsuarioRequest;
import com.proyectoFinal.gymtracker.DTO.Response.DiaRutinaResponse;
import com.proyectoFinal.gymtracker.DTO.Response.UsuarioResponse;
import com.proyectoFinal.gymtracker.Services.RutinaService;
import com.proyectoFinal.gymtracker.Services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {


    private final UsuarioService usuarioService;
    private final RutinaService rutinaService;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioResponse> registrar(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrar(usuarioRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.login(loginRequest));
    }

    @PutMapping("/{idUsuario}/rutina-activa/{idRutina}")
    public ResponseEntity<UsuarioResponse> activarRutina(@PathVariable Long idUsuario, @PathVariable Long idRutina) {
        return ResponseEntity.ok(usuarioService.activarRutina(idUsuario, idRutina));
    }

    @GetMapping("/{idUsuario}/hoy")
    public ResponseEntity<DiaRutinaResponse> getDiaActual(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(rutinaService.getDiaRutinaActual(idUsuario));
    }

}