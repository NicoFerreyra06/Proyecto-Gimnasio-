package com.proyectoFinal.gymtracker.repositories;

import com.proyectoFinal.gymtracker.Modelo.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio,Long> {
}
