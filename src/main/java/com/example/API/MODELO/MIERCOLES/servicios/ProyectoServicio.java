package com.example.API.MODELO.MIERCOLES.servicios;

import com.example.API.MODELO.MIERCOLES.modelos.PerfilEstudiante;
import com.example.API.MODELO.MIERCOLES.modelos.Proyecto;
import com.example.API.MODELO.MIERCOLES.modelos.dtos.ProyectoDTO;
import com.example.API.MODELO.MIERCOLES.modelos.mapas.IMapaProyectoDTO;
import com.example.API.MODELO.MIERCOLES.repositorios.IProyectoRepositorio;

import com.example.API.MODELO.MIERCOLES.repositorios.PerfilEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProyectoServicio {

    @Autowired
    private IProyectoRepositorio proyectoRepositorio;

    @Autowired
    private PerfilEstudianteRepositorio perfilEstudianteRepositorio;

    @Autowired
    private IMapaProyectoDTO mapaProyectoDTO;

    // Crear proyecto
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = mapaProyectoDTO.toEntity(proyectoDTO);

        // Asignar el perfilEstudiante correcto desde BD
        PerfilEstudiante perfil = perfilEstudianteRepositorio.findById(Long.valueOf(proyectoDTO.getPerfilEstudianteId()))
                .orElseThrow(() -> new RuntimeException("PerfilEstudiante no encontrado con ID: " + proyectoDTO.getPerfilEstudianteId()));

        proyecto.setPerfilEstudiante(perfil);

        Proyecto guardado = proyectoRepositorio.save(proyecto);
        return mapaProyectoDTO.toDTO(guardado);
    }

    // Listar todos
    public List<ProyectoDTO> listarProyectos() {
        return proyectoRepositorio.findAll()
                .stream()
                .map(mapaProyectoDTO::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public ProyectoDTO obtenerPorId(Long id) {
        Proyecto proyecto = proyectoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado con ID: " + id));
        return mapaProyectoDTO.toDTO(proyecto);
    }

    // Eliminar
    public void eliminarProyecto(Long id) {
        if (!proyectoRepositorio.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Proyecto no encontrado con ID: " + id);
        }
        proyectoRepositorio.deleteById(id);
    }

    // Buscar por perfil de estudiante
    public List<ProyectoDTO> buscarPorPerfilEstudiante(Long perfilEstudianteId) {
        return proyectoRepositorio.findByPerfilEstudiante_Id(perfilEstudianteId)
                .stream()
                .map(mapaProyectoDTO::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar por tecnología
    public List<ProyectoDTO> buscarPorTecnologia(String tecnologia) {
        return proyectoRepositorio.findByTecnologiasContainingIgnoreCase(tecnologia)
                .stream()
                .map(mapaProyectoDTO::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar por título
    public List<ProyectoDTO> buscarPorTitulo(String titulo) {
        return proyectoRepositorio.findByTituloContainingIgnoreCase(titulo)
                .stream()
                .map(mapaProyectoDTO::toDTO)
                .collect(Collectors.toList());
    }
}

