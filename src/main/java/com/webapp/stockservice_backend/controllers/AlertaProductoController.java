package com.webapp.stockservice_backend.controllers;

import com.webapp.stockservice_backend.models.AlertaProducto;
import com.webapp.stockservice_backend.services.AlertaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Controlador para las alertas de producto
@RestController
@RequestMapping("/api/alertas")
public class AlertaProductoController {

    @Autowired  // Inyección de dependencia del servicio de alertas de producto
    private AlertaProductoService alertaProductoService;

    // Método para registrar una alerta de producto
    @PostMapping("/registrar")
    public AlertaProducto registrarAlerta(@RequestBody AlertaProducto alerta) throws Exception { // Se recibe la alerta de producto en el cuerpo de la petición
        return alertaProductoService.registrarAlerta(alerta);
    }

    // Método para obtener todas las alertas de producto
    @GetMapping
    public List<AlertaProducto> obtenerAlertas() {
        return alertaProductoService.obtenerAlertas();
    }
}
