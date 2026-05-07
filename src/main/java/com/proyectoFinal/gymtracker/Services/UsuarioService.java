package com.proyectoFinal.gymtracker.Services;

import com.proyectoFinal.gymtracker.DTO.Request.LoginRequest;
import com.proyectoFinal.gymtracker.DTO.Request.UsuarioRequest;
import com.proyectoFinal.gymtracker.DTO.Response.UsuarioResponse;
import com.proyectoFinal.gymtracker.Modelo.Usuario;
import com.proyectoFinal.gymtracker.Repositories.UsuarioRepository;
import com.proyectoFinal.gymtracker.Enum.Rol;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    private UsuarioResponse toResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .rol(usuario.getRol())
                .codigoAmigo(usuario.getCodigoAmigo())
                .peso(usuario.getPeso())
                .altura(usuario.getAltura())
                .imc(usuario.getImc())
                .rachaActualDias(usuario.getRachaActualDias())
                .rachaMaximaDias(usuario.getRachaMaximaDias()).build();
    }


    public UsuarioResponse registrar(UsuarioRequest usuarioRequest) {

        if (usuarioRequest.getEmail() == null || usuarioRequest.getEmail().isEmpty()) {
            throw new RuntimeException("Email obligatorio");
        }

        if (usuarioRepository.findByEmail(usuarioRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email ya registrado");
        }

        if (usuarioRepository.findByUsername(usuarioRequest.getUsername()).isPresent()) {
            throw new RuntimeException("Username ya existe");
        }

        Usuario usuario = Usuario.builder()
                .username(usuarioRequest.getUsername())
                .email(usuarioRequest.getEmail())
                .password(usuarioRequest.getPassword())
                .peso(usuarioRequest.getPeso())
                .altura(usuarioRequest.getAltura())
                .rol(Rol.USUARIO)
                .codigoAmigo(UUID.randomUUID().toString())
                .build();

        Usuario saved = usuarioRepository.save(usuario);

        return toResponse(saved);
    }

    public UsuarioResponse login(LoginRequest loginRequest) {

        Usuario usuario = usuarioRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Password incorrecta");
        }

        return toResponse(usuario);
    }
}