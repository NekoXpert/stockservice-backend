package com.webapp.stockservice_backend.controllers;

import com.webapp.stockservice_backend.models.SolicitudServicio;
import com.webapp.stockservice_backend.services.SolicitudServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudServicioController {

    @Autowired
    private SolicitudServicioService solicitudServicioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarSolicitud(@RequestBody SolicitudServicio solicitud) throws Exception {
        return new ResponseEntity<>(solicitudServicioService.registrarSolicitud(solicitud), HttpStatus.CREATED);
    }

    @PutMapping("/asignar-tecnico/{solicitudId}/{tecnicoId}")
    public ResponseEntity<?> asignarTecnico(@PathVariable Long solicitudId, @PathVariable int tecnicoId)
            throws Exception {
        return new ResponseEntity<>(solicitudServicioService.asignarTecnico(solicitudId, tecnicoId), HttpStatus.OK);
    }

    @GetMapping
    public List<SolicitudServicio> obtenerSolicitudes() {
        return solicitudServicioService.obtenerSolicitudes();
    }

    @GetMapping("/filtrar-cliente")
    public List<SolicitudServicio> filtrarSolicitudesPorCliente(@RequestParam String clienteNombre) {
        return solicitudServicioService.filtrarSolicitudesPorCliente(clienteNombre);
    }

    @GetMapping("/filtrar-tecnico")
    public List<SolicitudServicio> filtrarSolicitudesPorTecnico(@RequestParam String tecnicoAsignado) {
        return solicitudServicioService.filtrarSolicitudesPorTecnico(tecnicoAsignado);
    }

    @PutMapping("/actualizar-estado/{solicitudId}")
    public ResponseEntity<?> actualizarEstado(@PathVariable Long solicitudId, @RequestParam String estado)
            throws Exception {
        return new ResponseEntity<>(solicitudServicioService.actualizarEstado(solicitudId, estado), HttpStatus.OK);
    }
}
