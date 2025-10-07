package com.example.API.MODELO.MIERCOLES.controladores;

import com.example.API.MODELO.MIERCOLES.modelos.PerfilEstudiante;
import com.example.API.MODELO.MIERCOLES.modelos.dtos.PerfilEstudianteDTO;
import com.example.API.MODELO.MIERCOLES.modelos.mapas.IMapaPerfilEstudianteDTO;
import com.example.API.MODELO.MIERCOLES.servicios.PerfilServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilEstudianteControlador {

    @Autowired
    private PerfilServicio perfilServicio;

    @Autowired
    private IMapaPerfilEstudianteDTO mapaPerfilEstudianteDTO;

    //  Listar todos los perfiles
    @GetMapping
    public List<PerfilEstudianteDTO> listarPerfiles() {
        List<PerfilEstudiante> perfiles = perfilServicio.listarTodos();
        return mapaPerfilEstudianteDTO.convertir_lista_a_dto(perfiles);
    }

    //  Crear un nuevo perfil
    @PostMapping
    public PerfilEstudianteDTO crearPerfil(@RequestBody PerfilEstudiante perfil) {
        PerfilEstudiante nuevo = perfilServicio.guardar(perfil);
        return mapaPerfilEstudianteDTO.convertir_modelo_a_dto(nuevo);
    }

    //  Buscar perfiles por experiencia
    @GetMapping("/buscar")
    public List<PerfilEstudianteDTO> buscarPorExperiencia(@RequestParam String experiencia) {
        List<PerfilEstudiante> resultados = perfilServicio.buscarPorExperiencia(experiencia);
        return mapaPerfilEstudianteDTO.convertir_lista_a_dto(resultados);
    }
}


