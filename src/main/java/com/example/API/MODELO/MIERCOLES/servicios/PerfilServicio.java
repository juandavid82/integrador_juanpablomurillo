package com.example.API.MODELO.MIERCOLES.servicios;

import com.example.API.MODELO.MIERCOLES.modelos.PerfilEstudiante;
import com.example.API.MODELO.MIERCOLES.repositorios.PerfilEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilServicio {

    @Autowired
    private PerfilEstudianteRepositorio perfilEstudianteRepositorio;


    public PerfilEstudiante guardar(PerfilEstudiante perfilEstudiante) {
        return perfilEstudianteRepositorio.save(perfilEstudiante);
    }


    public List<PerfilEstudiante> listarTodos() {
        return perfilEstudianteRepositorio.findAll();
    }


    public List<PerfilEstudiante> buscarPorExperiencia(String experiencia) {
        return perfilEstudianteRepositorio.findByExperienciaContainingIgnoreCase(experiencia);
    }
}
