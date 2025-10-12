package com.example.API.MODELO.MIERCOLES.controladores;

import com.example.API.MODELO.MIERCOLES.modelos.dtos.EstudianteDTO;
import com.example.API.MODELO.MIERCOLES.servicios.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio estudianteServicio;

    @GetMapping
    public List<EstudianteDTO> listar() {
        return estudianteServicio.listarEstudiantes();
    }

    @GetMapping("/{id}")
    public EstudianteDTO obtener(@PathVariable Long id) {
        return estudianteServicio.obtenerPorId(id);
    }

    @PostMapping
    public EstudianteDTO crear(@RequestBody EstudianteDTO estudianteDTO) {
        return estudianteServicio.crearEstudiante(estudianteDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estudianteServicio.eliminarEstudiante(id);
    }
}
