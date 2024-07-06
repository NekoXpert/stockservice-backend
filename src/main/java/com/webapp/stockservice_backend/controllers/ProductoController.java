package com.webapp.stockservice_backend.controllers;


import com.webapp.stockservice_backend.models.Producto;
import com.webapp.stockservice_backend.models.ProductoComponentePC;
import com.webapp.stockservice_backend.models.ProductoPeriferico;
import com.webapp.stockservice_backend.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Método para registrar un componente PC
    @PostMapping("/registrar/componente")
    public ResponseEntity<?> registrarComponente(@RequestBody ProductoComponentePC productoComponentePC) {
        try {
            ProductoComponentePC registrado = (ProductoComponentePC) productoService
                    .registrarProducto(productoComponentePC);
            return new ResponseEntity<>(registrado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar el componente PC: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para registrar un periférico
    @PostMapping("/registrar/periferico")
    public ResponseEntity<?> registrarPeriferico(@RequestBody ProductoPeriferico productoPeriferico) {
        try {
            ProductoPeriferico registrado = (ProductoPeriferico) productoService.registrarProducto(productoPeriferico);
            return new ResponseEntity<>(registrado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar el periférico: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar el stock de un producto
    @PutMapping("/actualizar-stock/{id}")
    public Producto actualizarStock(@PathVariable Long id, @RequestParam int cantidad) throws Exception {
        return productoService.actualizarStock(id, cantidad);
    }

    // Método para obtener los productos con bajo stock
    @GetMapping("/alertar-bajostock")
    public List<Producto> obtenerProductosConBajoStock() {
        return productoService.obtenerProductosConBajoStock();
    }

    // Método para filtrar productos por tipo
    @GetMapping("/filtrar-tipo")
    public List<Producto> filtrarProductosPorTipo(@RequestParam String tipo) {
        return productoService.filtrarProductosPorTipo(tipo);
    }

    // Método para filtrar productos por nombre
    @GetMapping("/filtrar-nombre")
    public List<Producto> filtrarProductosPorNombre(@RequestParam String nombre) {
        return productoService.filtrarProductosPorNombre(nombre);
    }

    // Método para obtener todos los productos
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }
}
