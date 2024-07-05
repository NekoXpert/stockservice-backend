package com.webapp.stockservice_backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.stockservice_backend.models.AlertaProducto;

@Repository
public interface AlertaProductoRepository extends JpaRepository<AlertaProducto, Long> {
    // Consultas adicionales aqui //
}
