package com.proyectoFinal.gymtracker.repositories;

import com.proyectoFinal.gymtracker.Modelo.DiaRutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaRutinaRepository extends JpaRepository<DiaRutina,Long> {
}
