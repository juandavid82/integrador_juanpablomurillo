package com.example.API.MODELO.MIERCOLES.repositorios;

import com.example.API.MODELO.MIERCOLES.ayudas.EstadosUsuario;
import com.example.API.MODELO.MIERCOLES.ayudas.RolesUsuario;
import com.example.API.MODELO.MIERCOLES.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {

    // Buscar usuario por correo
    Optional<Usuario> findByCorreo(String correo);

    // Buscar todos los usuarios por rol
    List<Usuario> findByRol(RolesUsuario rol);

    // (Opcional) Buscar todos los usuarios por estado
    List<Usuario> findByEstado(EstadosUsuario estado);

    boolean existsByCorreo(String correo);
}