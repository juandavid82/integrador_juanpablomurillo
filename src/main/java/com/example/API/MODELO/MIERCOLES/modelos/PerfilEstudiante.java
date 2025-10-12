package com.example.API.MODELO.MIERCOLES.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "perfil_estudiante")
public class PerfilEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resumen;
    private String intereses;
    private String experiencia;
    private String proyectos;

    @OneToOne
    @JoinColumn(name = "estudiante_id", nullable = false, unique = true)
    private Estudiante estudiante;

    public PerfilEstudiante() {
    }

    public PerfilEstudiante(Long id, String resumen, String intereses, String experiencia, String proyectos,Estudiante estudiante) {
        this.id = id;
        this.resumen = resumen;
        this.intereses = intereses;
        this.experiencia = experiencia;
        this.proyectos = proyectos;
        this.estudiante = estudiante;
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

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
}