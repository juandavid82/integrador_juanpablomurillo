package com.example.API.MODELO.MIERCOLES.controladores;

import com.example.API.MODELO.MIERCOLES.modelos.dtos.UsuarioDTO;
import com.example.API.MODELO.MIERCOLES.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioServicio.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtener(@PathVariable Long id) {
        return usuarioServicio.obtenerPorId(id);
    }

    @PostMapping
    public UsuarioDTO crear(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioServicio.crearUsuario(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioServicio.eliminarUsuario(id);
    }
}
