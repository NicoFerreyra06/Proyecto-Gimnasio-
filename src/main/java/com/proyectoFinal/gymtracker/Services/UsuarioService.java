package com.proyectoFinal.gymtracker.Services;

import com.proyectoFinal.gymtracker.Modelo.Usuario;
import com.proyectoFinal.gymtracker.Repositories.UsuarioRepository;
import com.proyectoFinal.gymtracker.Enum.Rol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    public Usuario registrar(Usuario usuario) {

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new RuntimeException("Email obligatorio");
        }

        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Email ya registrado");
        }

        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            throw new RuntimeException("Username ya existe");
        }

        if (usuario.getPassword() == null || usuario.getPassword().length() < 4) {
            throw new RuntimeException("Password muy corta");
        }

        usuario.setRol(Rol.USUARIO);


        usuario.setCodigoAmigo(UUID.randomUUID().toString());

        return usuarioRepository.save(usuario);
    }

    public Usuario login(String email, String password) {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(password)) {
            throw new RuntimeException("Password incorrecta");
        }

        return usuario;
    }
}