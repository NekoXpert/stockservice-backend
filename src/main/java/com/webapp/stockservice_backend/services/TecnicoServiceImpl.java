package com.webapp.stockservice_backend.services;


import com.webapp.stockservice_backend.models.Tecnico;
import com.webapp.stockservice_backend.repositories.TecnicoRepository;
import com.webapp.stockservice_backend.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoServiceImpl implements TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Override
    public Tecnico registrarTecnico(Tecnico tecnico) throws Exception {
        try {
            return tecnicoRepository.save(tecnico);
        } catch (Exception e) {
            throw new Exception("Error al registrar el técnico", e);
        }
    }

    @Override
    public List<Tecnico> obtenerTodosLosTecnicos() {
        return tecnicoRepository.findAll();
    }

    @Override
    public List<Tecnico> filtrarTecnicosPorDisponibilidad(boolean disponibilidad) {
        return tecnicoRepository.findAll().stream()
                .filter(tecnico -> tecnico.isDisponibilidad() == disponibilidad)
                .toList();
    }
}
