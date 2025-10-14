package com.example.API.MODELO.MIERCOLES.repositorios;

import com.example.API.MODELO.MIERCOLES.modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEstudianteRepositorio extends JpaRepository<Estudiante, Long> {

    // Buscar estudiantes por nombre del usuario relacionado
    List<Estudiante> findByUsuario_NombreContainingIgnoreCase(String nombre);


    //  campo "codigoEstudiante", lo puedes usar así:
    // Optional<Estudiante> findByCodigoEstudiante(String codigo);

}
