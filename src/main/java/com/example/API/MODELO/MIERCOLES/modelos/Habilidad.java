package com.example.API.MODELO.MIERCOLES.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "habilidades")
public class Habilidad {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column
    private String nombre;

    @NotNull
    @Column
    private int nivel;

    @NotNull
    @Size(min = 3, max = 20, message = "El tipo debe ser 'blanda' o 'técnica'")
    @Column
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "perfil_estudiante_id", nullable = false)
    private PerfilEstudiante perfilEstudiante;

    public Habilidad() {}

    public Habilidad(Long id, String nombre, int nivel, String tipo, PerfilEstudiante perfilEstudiante) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.perfilEstudiante = perfilEstudiante;
    }


    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PerfilEstudiante getPerfilEstudiante() {
        return perfilEstudiante;
    }

    public void setPerfilEstudiante(PerfilEstudiante perfilEstudiante) {
        this.perfilEstudiante = perfilEstudiante;
    }
}

