package com.example.API.MODELO.MIERCOLES.modelos.mapas;

import com.example.API.MODELO.MIERCOLES.modelos.Estudiante;
import com.example.API.MODELO.MIERCOLES.modelos.dtos.EstudianteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { IMapaUsuarioDTO.class })
public interface IMapaEstudianteDTO {

    // Entidad → DTO
    EstudianteDTO toDTO(Estudiante estudiante);

    // DTO → Entidad
    @Mapping(target = "id", ignore = true) // evita problemas con IDs null o duplicados
    Estudiante toEntity(EstudianteDTO estudianteDTO);
}
