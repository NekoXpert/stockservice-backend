package com.webapp.stockservice_backend.services;


import com.webapp.stockservice_backend.models.AlertaProducto;
import java.util.List;

public interface AlertaProductoService {
    AlertaProducto registrarAlerta(AlertaProducto alerta) throws Exception;

    List<AlertaProducto> obtenerAlertas();
}
