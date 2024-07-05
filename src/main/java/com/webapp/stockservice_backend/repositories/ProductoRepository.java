package com.webapp.stockservice_backend.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.webapp.stockservice_backend.models.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
  

  
  List<Producto> findByNombreContaining(String nombre);

}
