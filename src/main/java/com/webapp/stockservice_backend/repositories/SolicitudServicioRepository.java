package com.webapp.stockservice_backend.repositories;

import com.webapp.stockservice_backend.models.SolicitudServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SolicitudServicioRepository extends JpaRepository<SolicitudServicio, Long> {
    List<SolicitudServicio> findByClienteNombreContaining(String clienteNombre);

    List<SolicitudServicio> findByTecnicoAsignado(String tecnicoAsignado);
}
