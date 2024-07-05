package com.webapp.stockservice_backend.services;

import com.webapp.stockservice_backend.models.AlertaProducto;
import com.webapp.stockservice_backend.repositories.AlertaProductoRepository;
import com.webapp.stockservice_backend.services.AlertaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaProductoServiceImpl implements AlertaProductoService {

    @Autowired
    private AlertaProductoRepository alertaProductoRepository;

    @Override
    public AlertaProducto registrarAlerta(AlertaProducto alerta) throws Exception {
        try {
            return alertaProductoRepository.save(alerta);
        } catch (Exception e) {
            throw new Exception("Error al registrar la alerta del producto", e);
        }
    }

    @Override
    public List<AlertaProducto> obtenerAlertas() {
        return alertaProductoRepository.findAll();
    }
}
