package com.webapp.stockservice_backend.controllers;


import com.webapp.stockservice_backend.models.Producto;
import com.webapp.stockservice_backend.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/registrar")
    public Producto registrarProducto(@RequestBody Producto producto) throws Exception {
        return productoService.registrarProducto(producto);
    }

    @PutMapping("/actualizar-stock/{id}")
    public Producto actualizarStock(@PathVariable Long id, @RequestParam int cantidad) throws Exception {
        return productoService.actualizarStock(id, cantidad);
    }

    @GetMapping("/alertar-obsoletos")
    public List<Producto> obtenerProductosObsoletos() {
        return productoService.obtenerProductosObsoletos();
    }

    @GetMapping("/filtrar-tipo")
    public List<Producto> filtrarProductosPorTipo(@RequestParam String tipo) {
        return productoService.filtrarProductosPorTipo(tipo);
    }

    @GetMapping("/filtrar-nombre")
    public List<Producto> filtrarProductosPorNombre(@RequestParam String nombre) {
        return productoService.filtrarProductosPorNombre(nombre);
    }
}
