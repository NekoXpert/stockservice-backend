package com.webapp.stockservice_backend.models;

public enum Tecnico {
    ANA_PEREZ(1, "Ana Pérez", "Hardware"),
    DAVID_JIMENEZ(2, "David Jiménez", "Software"),
    JORGE_SANCHEZ(3, "Jorge Sánchez", "Hardware"),
    LAURA_RAMIREZ(4, "Laura Ramírez", "Software"),
    MARIA_FERNANDEZ(5, "María Fernández", "Hardware");

    private final int id;
    private final String nombre;
    private final String tipo;

    Tecnico(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public static Tecnico getById(int id) {
        for (Tecnico tecnico : values()) {
            if (tecnico.getId() == id) {
                return tecnico;
            }
        }
        return null; // or throw an exception if not found
    }
}
