package com.webapp.stockservice_backend.controllers;

import com.webapp.stockservice_backend.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/inventario")
    public ResponseEntity<byte[]> generarReporteInventario() throws Exception {
        byte[] reporte = reporteService.generarReporteInventario();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte_inventario.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(reporte);
    }

    @GetMapping("/solicitudes")
    public ResponseEntity<byte[]> generarReporteSolicitudes() throws Exception {
        byte[] reporte = reporteService.generarReporteSolicitudes();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte_solicitudes.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(reporte);
    }
}
