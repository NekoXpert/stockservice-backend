package com.webapp.stockservice_backend.controllers;

import com.webapp.stockservice_backend.models.AlertaProducto;
import com.webapp.stockservice_backend.services.AlertaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaProductoController {

    @Autowired
    private AlertaProductoService alertaProductoService;

    @PostMapping("/registrar")
    public AlertaProducto registrarAlerta(@RequestBody AlertaProducto alerta) throws Exception {
        return alertaProductoService.registrarAlerta(alerta);
    }

    @GetMapping
    public List<AlertaProducto> obtenerAlertas() {
        return alertaProductoService.obtenerAlertas();
    }
}
