package com.example.API.MODELO.MIERCOLES.modelos.mapas;

import com.example.API.MODELO.MIERCOLES.modelos.PerfilEstudiante;
import com.example.API.MODELO.MIERCOLES.modelos.dtos.PerfilEstudianteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaPerfilEstudianteDTO {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "resumen", target = "resumen")
    @Mapping(source = "intereses", target = "intereses")
    @Mapping(source = "experiencia", target = "experiencia")
    @Mapping(source = "proyectos", target = "proyectos")
    PerfilEstudianteDTO convertir_modelo_a_dto(PerfilEstudiante perfil);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "resumen", target = "resumen")
    @Mapping(source = "intereses", target = "intereses")
    @Mapping(source = "experiencia", target = "experiencia")
    @Mapping(source = "proyectos", target = "proyectos")
    PerfilEstudiante convertir_dto_a_modelo(PerfilEstudianteDTO dto);

    List<PerfilEstudianteDTO> convertir_lista_a_dto(List<PerfilEstudiante> lista);
    List<PerfilEstudiante> convertir_lista_a_modelo(List<PerfilEstudianteDTO> listaDTO);
}
