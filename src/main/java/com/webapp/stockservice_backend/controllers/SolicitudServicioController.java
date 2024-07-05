package com.webapp.stockservice_backend.controllers;

import com.webapp.stockservice_backend.models.SolicitudServicio;
import com.webapp.stockservice_backend.services.SolicitudServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudServicioController {

    @Autowired
    private SolicitudServicioService solicitudServicioService;

    @PostMapping("/registrar")
    public SolicitudServicio registrarSolicitud(@RequestBody SolicitudServicio solicitud) throws Exception {
        return solicitudServicioService.registrarSolicitud(solicitud);
    }

    @PutMapping("/asignar-tecnico/{solicitudId}/{tecnicoId}")
    public SolicitudServicio asignarTecnico(@PathVariable Long solicitudId, @PathVariable Long tecnicoId)
            throws Exception {
        return solicitudServicioService.asignarTecnico(solicitudId, tecnicoId);
    }

    @GetMapping
    public List<SolicitudServicio> obtenerSolicitudes() {
        return solicitudServicioService.obtenerSolicitudes();
    }

    @GetMapping("/filtrar-estado")
    public List<SolicitudServicio> filtrarSolicitudesPorEstado(@RequestParam String estado) {
        return solicitudServicioService.filtrarSolicitudesPorEstado(estado);
    }

    @GetMapping("/filtrar-cliente")
    public List<SolicitudServicio> filtrarSolicitudesPorCliente(@RequestParam String clienteNombre) {
        return solicitudServicioService.filtrarSolicitudesPorCliente(clienteNombre);
    }

    @PutMapping("/actualizar-estado/{solicitudId}")
    public SolicitudServicio actualizarEstado(@PathVariable Long solicitudId, @RequestParam String estado)
            throws Exception {
        return solicitudServicioService.actualizarEstado(solicitudId, estado);
    }
}
