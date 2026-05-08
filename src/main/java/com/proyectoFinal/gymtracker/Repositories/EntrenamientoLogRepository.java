package com.proyectoFinal.gymtracker.Repositories;

import com.proyectoFinal.gymtracker.Modelo.EntrenamientoLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrenamientoLogRepository extends JpaRepository<EntrenamientoLog,Long> {
    List<EntrenamientoLog> findByUsuarioId(Long idUsuario);
}
