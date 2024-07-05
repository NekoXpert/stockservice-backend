package com.webapp.stockservice_backend.services;

import java.util.List;

import com.webapp.stockservice_backend.models.Producto;

public interface ProductoService {
   
    Producto registrarProducto(Producto producto) throws Exception;

    Producto actualizarStock(Long id, int cantidad) throws Exception;

    List<Producto> obtenerProductosConBajoStock();

    List<Producto> filtrarProductosPorTipo(String tipo);

    List<Producto> filtrarProductosPorNombre(String nombre);

    List<Producto> obtenerProductos();
}
