package com.proyectoFinal.gymtracker.Services;

import com.proyectoFinal.gymtracker.Modelo.Musculo;
import com.proyectoFinal.gymtracker.Repositories.MusculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusculoService {

    private final MusculoRepository musculoRepository;

    public List<Musculo> addMusculos (List<Musculo> musculos){
        return musculoRepository.saveAll(musculos);
    }

    public void deleteMusculos(Long idMusculos){
        musculoRepository.deleteById(idMusculos);
    }
}
