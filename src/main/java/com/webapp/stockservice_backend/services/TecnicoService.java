package com.webapp.stockservice_backend.services;


import com.webapp.stockservice_backend.models.Tecnico;
import java.util.List;

public interface TecnicoService {
    Tecnico registrarTecnico(Tecnico tecnico) throws Exception;

    List<Tecnico> obtenerTodosLosTecnicos();

    List<Tecnico> filtrarTecnicosPorDisponibilidad(boolean disponibilidad);
}
