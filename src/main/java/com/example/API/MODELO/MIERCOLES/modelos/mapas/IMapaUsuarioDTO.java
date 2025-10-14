package com.example.API.MODELO.MIERCOLES.modelos.mapas;

import com.example.API.MODELO.MIERCOLES.modelos.Usuario;
import com.example.API.MODELO.MIERCOLES.modelos.dtos.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IMapaUsuarioDTO {

    // Entidad → DTO
    UsuarioDTO toDTO(Usuario usuario);

    // DTO → Entidad
    @Mapping(target = "id", ignore = true) // evita errores al crear nuevos registros
    Usuario toEntity(UsuarioDTO usuarioDTO);
}
