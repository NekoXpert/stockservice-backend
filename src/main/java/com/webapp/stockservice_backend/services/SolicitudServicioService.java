package com.webapp.stockservice_backend.services;

import com.webapp.stockservice_backend.models.SolicitudServicio;
import java.util.List;

public interface SolicitudServicioService {
    SolicitudServicio registrarSolicitud(SolicitudServicio solicitud) throws Exception;

    SolicitudServicio asignarTecnico(Long solicitudId, int tecnicoId) throws Exception;

    List<SolicitudServicio> obtenerSolicitudes();

    List<SolicitudServicio> filtrarSolicitudesPorCliente(String clienteNombre);

    List<SolicitudServicio> filtrarSolicitudesPorTecnico(String tecnicoAsignado);

    SolicitudServicio actualizarEstado(Long solicitudId, String estado) throws Exception;
}
