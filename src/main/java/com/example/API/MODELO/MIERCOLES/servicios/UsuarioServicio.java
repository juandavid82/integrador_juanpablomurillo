package com.example.API.MODELO.MIERCOLES.servicios;

import com.example.API.MODELO.MIERCOLES.modelos.Usuario;
import com.example.API.MODELO.MIERCOLES.modelos.dtos.UsuarioDTO;
import com.example.API.MODELO.MIERCOLES.modelos.mapas.IMapaUsuarioDTO;
import com.example.API.MODELO.MIERCOLES.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServicio {

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    @Autowired
    private IMapaUsuarioDTO mapaUsuarioDTO;

    // Crear usuario
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapaUsuarioDTO.toEntity(usuarioDTO);
        Usuario guardado = usuarioRepositorio.save(usuario);
        return mapaUsuarioDTO.toDTO(guardado);
    }

    // Listar todos
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepositorio.findAll()
                .stream()
                .map(mapaUsuarioDTO::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public UsuarioDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        return mapaUsuarioDTO.toDTO(usuario);
    }

    // Eliminar usuario
    public void eliminarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}
