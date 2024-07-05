package com.webapp.stockservice_backend.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;
    private boolean disponibilidad;

    @OneToMany(mappedBy = "tecnicoAsignado")
    private List<SolicitudServicio> solicitudes;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public List<SolicitudServicio> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<SolicitudServicio> solicitudes) {
        this.solicitudes = solicitudes;
    }

}
