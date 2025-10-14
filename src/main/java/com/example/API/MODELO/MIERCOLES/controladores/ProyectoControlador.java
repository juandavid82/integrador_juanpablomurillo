package com.example.API.MODELO.MIERCOLES.controladores;

import com.example.API.MODELO.MIERCOLES.modelos.dtos.ProyectoDTO;
import com.example.API.MODELO.MIERCOLES.servicios.ProyectoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin(origins = "*")
public class ProyectoControlador {

    @Autowired
    private ProyectoServicio proyectoServicio;

    // Crear proyecto
    @PostMapping
    public ProyectoDTO crearProyecto(@Valid @RequestBody ProyectoDTO proyectoDTO) {
        return proyectoServicio.crearProyecto(proyectoDTO);
    }

    // Listar todos
    @GetMapping
    public List<ProyectoDTO> listar() {
        return proyectoServicio.listarProyectos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ProyectoDTO obtenerPorId(@PathVariable Long id) {
        return proyectoServicio.obtenerPorId(id);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        proyectoServicio.eliminarProyecto(id);
    }

    // Buscar por perfil de estudiante
    @GetMapping("/perfil/{perfilEstudianteId}")
    public List<ProyectoDTO> buscarPorPerfil(@PathVariable Long perfilEstudianteId) {
        return proyectoServicio.buscarPorPerfilEstudiante(perfilEstudianteId);
    }

    // Buscar por tecnología
    @GetMapping("/tecnologia/{tecnologia}")
    public List<ProyectoDTO> buscarPorTecnologia(@PathVariable String tecnologia) {
        return proyectoServicio.buscarPorTecnologia(tecnologia);
    }

    // Buscar por título
    @GetMapping("/titulo/{titulo}")
    public List<ProyectoDTO> buscarPorTitulo(@PathVariable String titulo) {
        return proyectoServicio.buscarPorTitulo(titulo);
    }
}
