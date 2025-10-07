package com.example.API.MODELO.MIERCOLES.repositorios;

import com.example.API.MODELO.MIERCOLES.modelos.PerfilEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PerfilEstudianteRepositorio extends JpaRepository<PerfilEstudiante, Long> {

    List<PerfilEstudiante> findByExperienciaContainingIgnoreCase(String experiencia);
}

