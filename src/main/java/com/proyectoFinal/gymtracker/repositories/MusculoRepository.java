package com.proyectoFinal.gymtracker.repositories;

import com.proyectoFinal.gymtracker.Modelo.Musculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusculoRepository extends JpaRepository<Musculo, Long> {
}
