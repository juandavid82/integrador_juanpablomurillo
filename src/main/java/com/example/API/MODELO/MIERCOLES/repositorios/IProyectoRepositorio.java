package com.example.API.MODELO.MIERCOLES.repositorios;

import com.example.API.MODELO.MIERCOLES.modelos.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProyectoRepositorio extends JpaRepository<Proyecto, Long> {

    // Buscar proyectos por perfil de estudiante
    List<Proyecto> findByPerfilEstudiante_Id(Long perfilEstudianteId);

    // Buscar proyectos por tecnología (ej: "Java", "React")
    List<Proyecto> findByTecnologiasContainingIgnoreCase(String tecnologia);

    // Buscar proyectos por título
    List<Proyecto> findByTituloContainingIgnoreCase(String titulo);
}

