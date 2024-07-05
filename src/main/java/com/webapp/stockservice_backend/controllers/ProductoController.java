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


    @PutMapping("/actualizar-stock/{id}")
    public Producto actualizarStock(@PathVariable Long id, @RequestParam int cantidad) throws Exception {
        return productoService.actualizarStock(id, cantidad);
    }

    @GetMapping("/alertar-bajostock")
    public List<Producto> obtenerProductosConBajoStock() {
        return productoService.obtenerProductosConBajoStock();
    }

    @GetMapping("/filtrar-tipo")
    public List<Producto> filtrarProductosPorTipo(@RequestParam String tipo) {
        return productoService.filtrarProductosPorTipo(tipo);
    }

    @GetMapping("/filtrar-nombre")
    public List<Producto> filtrarProductosPorNombre(@RequestParam String nombre) {
        return productoService.filtrarProductosPorNombre(nombre);
    }

    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }
}
