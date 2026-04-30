package com.proyectoFinal.gymtracker.repositories;

import com.proyectoFinal.gymtracker.Modelo.MarcaEjercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaEjercicioRepository extends JpaRepository<MarcaEjercicio,Long> {
}
