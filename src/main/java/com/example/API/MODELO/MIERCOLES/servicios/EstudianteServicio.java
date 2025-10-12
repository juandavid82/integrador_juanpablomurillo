package com.example.API.MODELO.MIERCOLES.servicios;

import com.example.API.MODELO.MIERCOLES.modelos.Estudiante;
import com.example.API.MODELO.MIERCOLES.modelos.dtos.EstudianteDTO;
import com.example.API.MODELO.MIERCOLES.modelos.mapas.IMapaEstudianteDTO;
import com.example.API.MODELO.MIERCOLES.repositorios.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServicio {

    @Autowired
    private IEstudianteRepositorio estudianteRepositorio;

    @Autowired
    private IMapaEstudianteDTO mapaEstudianteDTO;

    // Crear estudiante
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapaEstudianteDTO.toEntity(estudianteDTO);
        Estudiante guardado = estudianteRepositorio.save(estudiante);
        return mapaEstudianteDTO.toDTO(guardado);
    }

    // Listar todos
    public List<EstudianteDTO> listarEstudiantes() {
        return estudianteRepositorio.findAll()
                .stream()
                .map(mapaEstudianteDTO::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public EstudianteDTO obtenerPorId(Long id) {
        Estudiante estudiante = estudianteRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));
        return mapaEstudianteDTO.toDTO(estudiante);
    }

    // Eliminar estudiante
    public void eliminarEstudiante(Long id) {
        estudianteRepositorio.deleteById(id);
    }
}
