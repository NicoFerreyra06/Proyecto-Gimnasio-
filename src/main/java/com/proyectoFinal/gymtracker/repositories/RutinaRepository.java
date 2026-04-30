package com.proyectoFinal.gymtracker.repositories;

import com.proyectoFinal.gymtracker.Modelo.Rutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutinaRepository extends JpaRepository<Rutina,Long> {
}
