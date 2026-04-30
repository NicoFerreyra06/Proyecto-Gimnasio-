package com.proyectoFinal.gymtracker.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenamientoLogRepository extends JpaRepository<EntrenamientoLogRepository,Long> {
}
