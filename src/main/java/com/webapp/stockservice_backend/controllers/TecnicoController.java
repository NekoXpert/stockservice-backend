package com.webapp.stockservice_backend.controllers;

import com.webapp.stockservice_backend.models.Tecnico;
import com.webapp.stockservice_backend.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @PostMapping("/registrar")
    public Tecnico registrarTecnico(@RequestBody Tecnico tecnico) throws Exception {
        return tecnicoService.registrarTecnico(tecnico);
    }

    @GetMapping
    public List<Tecnico> obtenerTodosLosTecnicos() {
        return tecnicoService.obtenerTodosLosTecnicos();
    }

    @GetMapping("/filtrar-disponibilidad")
    public List<Tecnico> filtrarTecnicosPorDisponibilidad(@RequestParam boolean disponibilidad) {
        return tecnicoService.filtrarTecnicosPorDisponibilidad(disponibilidad);
    }
}
