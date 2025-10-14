package com.example.API.MODELO.MIERCOLES.modelos.dtos;

public class PerfilEstudianteDTO {

    private Long id;
    private String resumen;
    private String intereses;
    private String experiencia;
    private String proyectos;
    private Long estudianteId;

    public PerfilEstudianteDTO() {
    }

    public PerfilEstudianteDTO(Long id, String resumen, String intereses, String experiencia, String proyectos) {
        this.id = id;
        this.resumen = resumen;
        this.intereses = intereses;
        this.experiencia = experiencia;
        this.proyectos = proyectos;
    }

    // --- Getters y Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getProyectos() {
        return proyectos;
    }

    public void setProyectos(String proyectos) {
        this.proyectos = proyectos;
    }

    public Long getEstudianteId() { return estudianteId; }
    public void setEstudianteId(Long estudianteId) { this.estudianteId = estudianteId; }
}