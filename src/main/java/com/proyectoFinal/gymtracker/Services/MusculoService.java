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

    public Musculo addMusculo(Musculo musculo){
        return musculoRepository.save(musculo);
    }

    public List<Musculo> addMusculos (List<Musculo> musculos){
        return musculoRepository.saveAll(musculos);
    }

    public void deleteMusculos(Long idMusculo){
        musculoRepository.deleteById(idMusculo);
    }

    public Musculo getMusculoById(Long idMusculo){
        return musculoRepository.findById(idMusculo)
                .orElseThrow(()-> new RuntimeException("Musculo no encontrado"));
    }

    public List<Musculo> getMusculos(){
        return musculoRepository.findAll();
    }
}
