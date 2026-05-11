package com.proyectoFinal.gymtracker.Services;

import com.proyectoFinal.gymtracker.DTO.Request.RecordPersonalRequest;
import com.proyectoFinal.gymtracker.Modelo.Ejercicio;
import com.proyectoFinal.gymtracker.Modelo.RecordPersonal;
import com.proyectoFinal.gymtracker.Modelo.Usuario;
import com.proyectoFinal.gymtracker.Repositories.EjercicioRepository;
import com.proyectoFinal.gymtracker.Repositories.RecordPersonalRepository;
import com.proyectoFinal.gymtracker.Repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordPersonalService {

    private final RecordPersonalRepository recordPersonalRepository;
    private final UsuarioRepository usuarioRepository;
    private final EjercicioRepository ejercicioRepository;

    public RecordPersonal actualizarRecordPersonal(RecordPersonalRequest recordPersonalRequest) {
        Usuario usuario = usuarioRepository.findById(recordPersonalRequest.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Ejercicio ejercicio = ejercicioRepository.findById(recordPersonalRequest.getIdEjercicio())
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));

        RecordPersonal recordExistente = recordPersonalRepository
                .findByUsuarioIdAndEjercicioId(usuario.getId(), ejercicio.getId());

        if (recordExistente != null) {
            if (recordPersonalRequest.getPesoMaximo() > recordExistente.getPesoMaximo()){
                recordExistente.setPesoMaximo(recordPersonalRequest.getPesoMaximo());
                recordExistente.setFechaLogro(LocalDate.now());
            } else {
                throw new RuntimeException("El peso ingresado no supera el record actual.");
            }
        }

        RecordPersonal recordPersonal = RecordPersonal.builder()
                .usuario(usuario)
                .ejercicio(ejercicio)
                .pesoMaximo(recordPersonalRequest.getPesoMaximo())
                .fechaLogro(LocalDate.now())
                .build();

        return recordPersonalRepository.save(recordPersonal);
    }

    // Muestro el record personal en 1 ejercicio de 1 usuario.
    public RecordPersonal getRecordPersonalByEjercicioId(Long usuarioId, Long ejercicioId) {
        return recordPersonalRepository.findByUsuarioIdAndEjercicioId(usuarioId, ejercicioId);
    }

    // Muestro los record personales en todos los ejercicios de 1 usuario.
    public List<RecordPersonal> getRecordsPersonalesByUsuarioId(Long usuarioId) {
        return recordPersonalRepository.findRecordPersonalByUsuarioId(usuarioId);
    }

    /* Se podría hacer un metodo que muestre un top de records personales
     entre todos los usuarios por ejercicio. */

}
